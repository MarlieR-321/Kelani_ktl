package uca.ni.edu.kelani.fragments.system.agregar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.viewmodel.ClienteViewModel
import uca.ni.edu.kelani.databinding.FragmentAgregarClientesBinding

class AgregarClientesFragment : Fragment() {
    lateinit var  binding: FragmentAgregarClientesBinding
    private lateinit var viewModel: ClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgregarClientesBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(ClienteViewModel::class.java)
        binding.btnGuardarClient.setOnClickListener {
            guardarRegistro()
        }
        return binding.root
    }

    private fun guardarRegistro() {

        val nomb = binding.itemNombClient.text.toString()
        val apell = binding.itemApellClient.text.toString()
        val telef = binding.itemTelefClient.text.toString()
        val cedul = binding.itemCedulaClient.text.toString()
        val dir = binding.itemDireccionClient.text.toString()

        if (nomb.isNotEmpty() && apell.isNotEmpty() && telef.isNotEmpty() && cedul.isNotEmpty() && dir.isNotEmpty())
        {
            //Crear objeto
            val client = Cliente(0,nomb,apell,telef,cedul,dir,1)

            //Agregar nuevo usuario
            viewModel.agregarCliente(client)
            Toast.makeText(requireContext(), "Registro guardado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.ir_nav_clients)
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