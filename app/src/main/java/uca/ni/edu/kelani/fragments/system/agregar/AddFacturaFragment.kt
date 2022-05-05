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
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas50.bd.dao.bdKealni
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.dao.FacturaDao
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.databinding.FragmentAddFacturaBinding
import java.util.*


class AddFacturaFragment : Fragment() {
    private lateinit var binding: FragmentAddFacturaBinding
    private lateinit var mDateSetListener: DatePickerDialog.OnDateSetListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddFacturaBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        datePicker()
        initSpinners()

        binding.spCliente.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long,
            ) {
                val full = binding.spCliente.selectedItem.toString()
                val id = getIdCliente(full)
                if(id!=0){
                    val cl:Cliente = getCliente(id)
                    if (cl != null){
                        initTextView(cl)
                    }
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }

        binding.btnSave.setOnClickListener {
            findNavController().navigate(R.id.addFacturaDetFragment)
        }
    }

    private fun guardar(){

    }

    private fun getCliente(id:Int):Cliente{
        val dbinstance =bdKealni.getDataBase(requireContext().applicationContext)
        val dao:FacturaDao = dbinstance.facturaDao()
        var cliente: Cliente = Cliente(0,"","","","","",0)

        CoroutineScope(Dispatchers.Main).launch {
            val cl = dao.getClienteById(id)
            //cliente.id_cliente = cl.id_cliente

        }

        return cliente
    }

    private fun getIdCliente(full:String):Int{
        if(full == "Seleccione..."){
            return 0
        }else{
            val id = full.split("-")
            return id[0].toInt()
        }
    }

    private fun initTextView(cl: Cliente){
        with(binding){
            itDireccion.setText(cl.direccion)
            itTelefono.setText(cl.telefono)
        }
    }

    private fun initSpinners(){
        val dbinstance =bdKealni.getDataBase(requireContext().applicationContext)
        val dao:FacturaDao = dbinstance.facturaDao()

        var listClientes:ArrayList<String> = arrayListOf("Seleccione...")

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
        binding.spCliente.adapter = adapterC
    }

    private fun datePicker(){
        binding.itFecha.setOnClickListener {
            var cal: Calendar = Calendar.getInstance()
            var year = cal.get(Calendar.YEAR)
            var month = cal.get(Calendar.MONTH)
            var day = cal.get(Calendar.DAY_OF_MONTH)

            var dialog = DatePickerDialog(
                requireContext(), android.R.style.Theme_Holo_Dialog_MinWidth,
                mDateSetListener, year, month,day
            )

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }

        mDateSetListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            binding.itFecha.setText("$day / ${month+1} / $year")
        }

    }
}