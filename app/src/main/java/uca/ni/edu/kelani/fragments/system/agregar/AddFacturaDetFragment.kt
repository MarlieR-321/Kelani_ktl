package uca.ni.edu.kelani.fragments.system.agregar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas50.bd.dao.bdKealni
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.dao.FacturaDao
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.FacturaDet
import uca.ni.edu.kelani.bd.entidades.Producto
import uca.ni.edu.kelani.bd.viewmodel.FacturaDetViewModel
import uca.ni.edu.kelani.bd.viewmodel.FacturaViewModel
import uca.ni.edu.kelani.databinding.FragmentAddFacturaDetBinding
import java.util.ArrayList


class AddFacturaDetFragment : Fragment() {

    private lateinit var binding: FragmentAddFacturaDetBinding
    var precio = 0.0
    private lateinit var viewModel : FacturaDetViewModel
    private val args by navArgs<AddFacturaDetFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAddFacturaDetBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[FacturaDetViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSpinners()
        binding.spProducto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val full = binding.spProducto.selectedItem.toString()
                val id = getIdProducto(full)
                if (id != 0) {
                    getProducto(id)
                }

            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.itCantidad.addTextChangedListener {
            initTextView(precio)
        }


        binding.btnNew.setOnClickListener {
            guardar()
        }
    }

    private fun guardar(){
        val nproducto = binding.spProducto.selectedItem.toString()
        val cantidad = binding.itCantidad.text.toString()
        val subtotal = binding.itSubtotal.text.toString()

        if(nproducto != "Seleccione...")
        {
            if (cantidad.isNotEmpty()&&subtotal.isNotEmpty())
            {
                val id = getIdProducto(nproducto)
                val fd = FacturaDet(0,args.id,id, cantidad.toInt(), subtotal.toDouble(),1)
                viewModel.agregarFacturaDet(fd)

                val action = AddFacturaDetFragmentDirections.actionFrmFacturaDetFragmentToFacturacionDetFragment(args.id)
                findNavController().navigate(action)
                Toast.makeText(requireContext(), "Registro guardado", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(requireContext(), "Ingrese una cantidad valida", Toast.LENGTH_LONG).show()
            }
        }
        else
        {
            Toast.makeText(requireContext(), "Seleccione un producto", Toast.LENGTH_LONG).show()
        }

    }

    private fun initSpinners(){
        val dbinstance = bdKealni.getDataBase(requireContext().applicationContext)
        val dao: FacturaDao = dbinstance.facturaDao()

        var listProductos: ArrayList<String> = arrayListOf("Seleccione...")

        try {
            CoroutineScope(Dispatchers.Main).launch {
                val listaProductos:List<Producto> = dao.getProducto()

                if(listaProductos.isNotEmpty()){
                    listaProductos.forEach {
                        listProductos.add("${it.id_producto}/  ${it.nombre}")
                    }
                }

            }
        }catch (e:Exception){
            e.toString()
        }

        val adapterC: ArrayAdapter<String> = ArrayAdapter<String>(requireContext().applicationContext,R.layout.sp_item, listProductos)
        binding.spProducto.adapter = adapterC
    }

    private fun getIdProducto(full:String):Int{
        return if(full == "Seleccione..."){
            0
        }else{
            val id = full.split("/")
            id[0].toInt()
        }
    }

    private fun getProducto(id:Int){
        val dbinstance =bdKealni.getDataBase(requireContext().applicationContext)
        val dao:FacturaDao = dbinstance.facturaDao()

        CoroutineScope(Dispatchers.Main).launch {
            val cl = dao.getProductoById(id)
            precio = cl.precio
            initTextView(precio)
        }
    }

    private fun initTextView(cl:Double){
        with(binding){
            var subtotal = 0.0
            if (itCantidad.text.toString().isNotEmpty()){
                subtotal = cl * itCantidad.text.toString().toInt()
            }
            itSubtotal.setText("$subtotal")
        }
    }

}