package uca.ni.edu.kelani.fragments.system.agregar

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.item_productos.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.dao.*
import uca.ni.edu.kelani.bd.entidades.*
import uca.ni.edu.kelani.bd.repository.CategoriaRepository
import uca.ni.edu.kelani.bd.repository.UnidadMedidaRepository
import uca.ni.edu.kelani.bd.viewmodel.FacturaViewModel
import uca.ni.edu.kelani.bd.viewmodel.ProductoViewModel
import uca.ni.edu.kelani.databinding.FragmentAddFacturaBinding
import uca.ni.edu.kelani.databinding.FragmentAgregarProductosBinding
import java.util.*

class AgregarProductosFragment : Fragment(){

    private lateinit var binding: FragmentAgregarProductosBinding
    private lateinit var viewModel : ProductoViewModel
    private lateinit var listaUnidad: List<UnidadMedida>
    private lateinit var listaCategoria: List<Categoria>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgregarProductosBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ProductoViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initSpinners()
        initSpinnersCategoria()

        binding.spUnidad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val full = binding.spUnidad.selectedItem.toString()
                val id = getIdUnidad(full)
                if (id != 0) {
                    getUnidad(id)
                }

            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.spCategoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val full = binding.spCategoria.selectedItem.toString()
                val id = getIdCategoria(full)
                if (id != 0) {
                    getCategoria(id)
                }

            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.btnGuardarProduct.setOnClickListener {
            guardar()
        }
    }

    private fun guardar(){
        with(binding){
            val nombre = itNombreProducto.text.toString()
            val descripcion = itDescripcionProducto.text.toString()
            val precio = itPrecioProducto.text.toString()
            val costo = itCostoProducto.text.toString()
            val unidad = spUnidad.selectedItem.toString()
            val abreviacion = itAbreviacionUnidad.text.toString()
            val categoria = spCategoria.selectedItem.toString()
            val descripcion_categoria = itDescripcionCategoria.text.toString()

            if (unidad != "Seleccione...")
            {
                if (nombre.isNotEmpty() && descripcion.isNotEmpty() && precio.isNotEmpty() && costo.isNotEmpty() && abreviacion.isNotEmpty() && descripcion_categoria.isNotEmpty())
                {
                    val idUnidad = getIdUnidad(unidad)
                    val idCategoria = getIdCategoria(categoria)

                    val producto = Producto(0, idUnidad, abreviacion, idCategoria, descripcion_categoria, nombre, descripcion, precio.toDouble(), costo.toDouble(),1 )
                    viewModel.agregarProducto(producto)
                    viewModel.fetchProducto()

                    findNavController().navigate(R.id.nav_product)
                }
                else
                {
                    Toast.makeText(requireContext(), "Complete todos los datos por favor", Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(requireContext(), "Elija una Unidad de Medida o Categoria", Toast.LENGTH_LONG).show()
            }


        }
    }

    private fun getUnidad(id:Int){
        /*val dbinstance = bdKealni.getDataBase(requireContext().applicationContext)
        val dao:ProductoDao = dbinstance.productoDao()

        CoroutineScope(Dispatchers.Main).launch {
            val unidad = dao.getUnidadById(id)
            initTextView(unidad)
        }*/

        if (listaUnidad.isNotEmpty()){
            listaUnidad.forEach{
                if (it.id_unidad == id){
                    initTextView(it)
                }
            }
        }

    }

    private fun getIdUnidad(full:String):Int{
        return if(full == "Seleccione..."){
            0
        }else{
            val id = full.split("-")
            id[0].toInt()
        }
    }

    private fun initTextView(unidad: UnidadMedida){
        with(binding){
            itAbreviacionUnidad.setText(unidad.abreviatura)
        }
    }

    private fun initSpinners(){
        val dbinstance = bdKealni.getDataBase(requireContext().applicationContext)
        val dao: UnidadMedidaDao = dbinstance.unidadtDao()

        var listUnidad: ArrayList<String> = arrayListOf("Seleccione...")

        try {
            CoroutineScope(Dispatchers.Main).launch {
                //val listaUnidad:List<UnidadMedida> = dao.getUnidades()

                val repo = UnidadMedidaRepository(dao)

                //listaUnidad = repo.getUnidad()

                if(listaUnidad.isNotEmpty()){
                    listaUnidad.forEach {
                        listUnidad.add("${it.id_unidad}-${it.nombre_unidad}")
                    }
                }

            }
        }catch (e:Exception){
            e.toString()
        }

        val adapterU: ArrayAdapter<String> = ArrayAdapter<String>(requireContext().applicationContext,R.layout.sp_item, listUnidad)
        binding.spUnidad.adapter = adapterU
    }

    private fun getCategoria(id:Int){
        /*val dbinstance = bdKealni.getDataBase(requireContext().applicationContext)
        val dao:ProductoDao = dbinstance.productoDao()

        CoroutineScope(Dispatchers.Main).launch {
            val categoria = dao.getCategoriaById(id)
            initTextViewCategoria(categoria)*/

        if (listaCategoria.isNotEmpty()){
            listaCategoria.forEach{
                if (it.id_categoria == id){
                    initTextViewCategoria(it)
                }
            }

        }
    }

    private fun getIdCategoria(full:String):Int{
        return if(full == "Seleccione..."){
            0
        }else{
            val id = full.split("-")
            id[0].toInt()
        }
    }

    private fun initTextViewCategoria(categoria: Categoria){
        with(binding){
            itDescripcionCategoria.setText(categoria.descripcion)
        }
    }

    private fun initSpinnersCategoria(){
        val dbinstance = bdKealni.getDataBase(requireContext().applicationContext)
        val dao: CategoriaDao = dbinstance.categoriatDao()

        var listCategoria: ArrayList<String> = arrayListOf("Seleccione...")

        try {
            CoroutineScope(Dispatchers.Main).launch {
                //val listaCategoria:List<Categoria> = dao.getCategoria()

                val repo = CategoriaRepository(dao)

                listaCategoria = repo.getCategories()

                if(listaCategoria.isNotEmpty()){
                    listaCategoria.forEach {
                        listCategoria.add("${it.id_categoria}-${it.nombre_categoria}")
                    }
                }

            }
        }catch (e:Exception){
            e.toString()
        }

        val adapterC: ArrayAdapter<String> = ArrayAdapter<String>(requireContext().applicationContext,R.layout.sp_item, listCategoria)
        binding.spCategoria.adapter = adapterC
    }

}