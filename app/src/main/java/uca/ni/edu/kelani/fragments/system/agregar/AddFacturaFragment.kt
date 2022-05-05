package uca.ni.edu.kelani.fragments.system.agregar

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.viewmodel.FacturaViewModel
import uca.ni.edu.kelani.databinding.FragmentAddFacturaBinding
import java.util.*


class AddFacturaFragment : Fragment() {
    private lateinit var binding: FragmentAddFacturaBinding
    private lateinit var mDateSetListener: DatePickerDialog.OnDateSetListener
    private lateinit var viewModel: FacturaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddFacturaBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[FacturaViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        datePicker()
        initSpinners()


        binding.btnSave.setOnClickListener {
            findNavController().navigate(R.id.addFacturaDetFragment)
        }
    }

    private fun guardar(){

    }

    private fun initSpinners(){
        var listClientes = arrayListOf("Seleccione...")
        lateinit var cl: List<Cliente>
        viewModel.listaClientes.observe(viewLifecycleOwner, androidx.lifecycle.Observer { cl-> })

        viewModel.listaClientes.value!!.forEach {
            listClientes.add("${it.nombre} ${it.apellido}")
        }

        val adapterC: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(),R.layout.sp_item, listClientes)
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