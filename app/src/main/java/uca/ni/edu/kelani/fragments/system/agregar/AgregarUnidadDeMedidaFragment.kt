package uca.ni.edu.kelani.fragments.system.agregar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.UnidadMedida
import uca.ni.edu.kelani.bd.viewmodel.UnidadMedidaViewModel
import uca.ni.edu.kelani.databinding.FragmentAgregarUnidadBinding

class AgregarUnidadDeMedidaFragment : Fragment() {
    private  lateinit var  binding: FragmentAgregarUnidadBinding
    private lateinit var viewModel: UnidadMedidaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgregarUnidadBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(UnidadMedidaViewModel::class.java)
        binding.btnGuardarMedida.setOnClickListener {
            guardarRegistro()
        }
        return binding.root
    }

    private fun guardarRegistro() {

        val nomb = binding.itemMedida.text.toString()
        val desc = binding.itemDescripcion.text.toString()


        if (nomb.isNotEmpty() && desc.isNotEmpty())
        {
            //Crear objeto
            val measure = UnidadMedida(0,nomb,desc,1)

            //Agregar nueva Unidad
            viewModel.agregarMedida(measure)
            Toast.makeText(requireContext(), "Registro guardado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.ir_a_nav_unidad)
        }
        else
        {
            Toast.makeText(requireContext(), "Debe rellenar todos los campos", Toast.LENGTH_LONG).show()
        }


    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGuardarClient.setOnClickListener {
            findNavController().navigate(R.id.ir_nav_clients)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}

