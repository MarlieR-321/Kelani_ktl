package uca.ni.edu.kelani.fragments.system.agregar

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.databinding.FragmentFacturacionBinding
import uca.ni.edu.kelani.databinding.FragmentFrmFacturaBinding
import java.util.*


class FrmFacturaFragment : Fragment() {
    private lateinit var binding: FragmentFrmFacturaBinding
    private lateinit var mDateSetListener: DatePickerDialog.OnDateSetListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFrmFacturaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        datePicker()

        binding.btnSave.setOnClickListener {
            findNavController().navigate(R.id.frmFacturaDetFragment)
        }
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