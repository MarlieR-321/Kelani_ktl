package uca.ni.edu.kelani.fragments.system.update_delete

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_up_del_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.dao.ProductoDao
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.bd.entidades.Producto
import uca.ni.edu.kelani.bd.entidades.UnidadMedida
import uca.ni.edu.kelani.bd.viewmodel.ProductoViewModel
import uca.ni.edu.kelani.databinding.FragmentAgregarProductosBinding
import uca.ni.edu.kelani.databinding.FragmentUpDelProductoBinding


class UpDelProductoFragment : Fragment() {

    lateinit var _binding: FragmentAgregarProductosBinding
    lateinit var binding: FragmentUpDelProductoBinding
    private val args by navArgs<UpDelProductoFragmentArgs>()
    private lateinit var viewModel: ProductoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentUpDelProductoBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)
        with(binding){
            itNombreProducto.setText(args.currentProducto.nombre_producto)
            itDescripcionProducto.setText(args.currentProducto.descripcion)
            itPrecioProducto.setText(args.currentProducto.precio.toString())
            itCostoProducto.setText(args.currentProducto.costo.toString())
            //spCategoria.setSelection(args.currentProducto.id_categoria)
            //_binding.spUnidad.selectedItem
            //itDescripcionCategoeria.setText(args.currentProducto.descripcion_categoria)
            //spUnidad
            //itAbreviacionUnidad.setText(args.currentProducto.abreviatura)



            edit.setOnClickListener{
                GuardarCambios()
            }

            del.setOnClickListener{
                EliminarProducto()
            }

        }
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSpinners()
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

    }

    private fun getUnidad(id:Int){
        val dbinstance = bdKealni.getDataBase(requireContext().applicationContext)
        val dao: ProductoDao = dbinstance.productoDao()

        CoroutineScope(Dispatchers.Main).launch {
            val unidad = dao.getUnidadById(id)
            initTextView(unidad)
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
        val dao: ProductoDao = dbinstance.productoDao()

        var listUnidad: ArrayList<String> = arrayListOf("Seleccione...")

        try {
            CoroutineScope(Dispatchers.Main).launch {
                val listaUnidad:List<UnidadMedida> = dao.getUnidades()

                if(listaUnidad.isNotEmpty()){
                    listaUnidad.forEach {
                        listUnidad.add("${it.id_unidad}-${it.nombre_unidad}")
                    }
                }

            }
        }catch (e:Exception){
            e.toString()
        }

        val adapterU: ArrayAdapter<String> = ArrayAdapter<String>(requireContext().applicationContext,
            R.layout.sp_item, listUnidad)
        binding.spUnidad.adapter = adapterU
    }

    private fun getCategoria(id:Int){
        val dbinstance = bdKealni.getDataBase(requireContext().applicationContext)
        val dao: ProductoDao = dbinstance.productoDao()

        CoroutineScope(Dispatchers.Main).launch {
            val categoria = dao.getCategoriaById(id)
            initTextViewCategoria(categoria)
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
            itDescripcionCategoeria.setText(categoria.descripcion)
        }
    }

    private fun initSpinnersCategoria(){
        val dbinstance = bdKealni.getDataBase(requireContext().applicationContext)
        val dao: ProductoDao = dbinstance.productoDao()

        var listCategoria: ArrayList<String> = arrayListOf("Seleccione...")

        try {
            CoroutineScope(Dispatchers.Main).launch {
                val listaCategoria:List<Categoria> = dao.getCategoria()

                if(listaCategoria.isNotEmpty()){
                    listaCategoria.forEach {
                        listCategoria.add("${it.id_categoria}-${it.nombre_categoria}")
                    }
                }

            }
        }catch (e:Exception){
            e.toString()
        }

        val adapterC: ArrayAdapter<String> = ArrayAdapter<String>(requireContext().applicationContext,
            R.layout.sp_item, listCategoria)
        binding.spCategoria.adapter = adapterC
    }

    private fun GuardarCambios(){
        with(binding){
            val nombreProducto = itNombreProducto.text.toString()
            val descripcionProducto = itDescripcionProducto.text.toString()
            val precioProducto = itPrecioProducto.text.toString()
            val costoProducto = itCostoProducto.text.toString()
            val unidad = spUnidad.selectedItem.toString()
            val abreviacion = itAbreviacionUnidad.text.toString()
            val categoria = spCategoria.selectedItem.toString()
            val descripcion_categoria = itDescripcionCategoeria.text.toString()

            if (unidad != "Seleccione...")
            {
                if (nombreProducto.isNotEmpty() && descripcionProducto.isNotEmpty() && precioProducto.isNotEmpty() && costoProducto.isNotEmpty() && abreviacion.isNotEmpty() && descripcion_categoria.isNotEmpty())
                {
                    val idUnidad = getIdUnidad(unidad)
                    val idCategoria = getIdCategoria(categoria)

                    val producto = Producto(args.currentProducto.id_producto, idUnidad, abreviacion, idCategoria, descripcion_categoria, nombreProducto, descripcionProducto, precioProducto.toDouble(), costoProducto.toDouble(),2 )
                    viewModel.actualizarProducto(producto)
                    Toast.makeText(requireContext(), "Producto actualizado", Toast.LENGTH_SHORT).show()
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

    private fun EliminarProducto(){

        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si"){_, _ ->

            val nombreProducto = itNombreProducto.text.toString()
            val descripcionProducto = itDescripcionProducto.text.toString()
            val precioProducto = itPrecioProducto.text.toString()
            val costoProducto = itCostoProducto.text.toString()
            val unidad = spUnidad.selectedItem.toString()
            val abreviacion = itAbreviacionUnidad.text.toString()
            val categoria = spCategoria.selectedItem.toString()
            val descripcion_categoria = itDescripcionCategoeria.text.toString()

            val idUnidad = getIdUnidad(unidad)
            val idCategoria = getIdCategoria(categoria)

            val producto = Producto(args.currentProducto.id_producto, idUnidad, abreviacion, idCategoria, descripcion_categoria, nombreProducto, descripcionProducto, precioProducto.toDouble(), costoProducto.toDouble(),3 )

            viewModel.eliminarProducto(producto)
            Toast.makeText(requireContext(), "Producto eliminado satisfactoriamente...", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.nav_product)
        }

        alerta.setNegativeButton("No"){_, _ ->
            Toast.makeText(requireContext(), "Producto no eliminado", Toast.LENGTH_SHORT).show()
        }
        alerta.setTitle("¿Desea eliminar ${args.currentProducto.nombre_producto}?")
        alerta.setMessage("¿Esta seguro de eliminar ${args.currentProducto.nombre_producto}?")
        alerta.create().show()

    }



}