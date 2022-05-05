package uca.ni.edu.kelani.fragments.system.agregar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas50.bd.dao.bdKealni
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.dao.FacturaDao
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.databinding.FragmentAddFacturaDetBinding
import java.util.ArrayList


class AddFacturaDetFragment : Fragment() {

    private lateinit var binding: FragmentAddFacturaDetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAddFacturaDetBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNew.setOnClickListener {
            findNavController().navigate(R.id.facturacionDetFragment)
        }
    }

    private fun initSpinners(){
        val dbinstance = bdKealni.getDataBase(requireContext().applicationContext)
        val dao: FacturaDao = dbinstance.facturaDao()

        var listClientes: ArrayList<String> = arrayListOf("Seleccione...")

        try {
            CoroutineScope(Dispatchers.Main).launch {
                val listaCliente:List<Cliente> = dao.getClientes()

                if(listaCliente.isNotEmpty()){
                    listaCliente.forEach {
                        listClientes.add("${it.id_cliente}-${it.nombre} ${it.apellido}")
                    }
                }

            }
        }catch (e:Exception){
            e.toString()
        }

        val adapterC: ArrayAdapter<String> = ArrayAdapter<String>(requireContext().applicationContext,R.layout.sp_item, listClientes)
        binding.spProducto.adapter = adapterC
    }

}