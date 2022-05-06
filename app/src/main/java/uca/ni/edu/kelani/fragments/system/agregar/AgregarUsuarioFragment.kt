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
import uca.ni.edu.kelani.bd.entidades.Usuario
import uca.ni.edu.kelani.bd.viewmodel.ClienteViewModel
import uca.ni.edu.kelani.bd.viewmodel.UsuarioViewModel
import uca.ni.edu.kelani.databinding.FragmentAgregarClientesBinding
import uca.ni.edu.kelani.databinding.FragmentAgregarUsuarioBinding

class AgregarUsuarioFragment : Fragment() {
    lateinit var  binding: FragmentAgregarUsuarioBinding
    private lateinit var viewModel: UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgregarUsuarioBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        binding.btnGuardarUser.setOnClickListener {
            guardarRegistro()
        }
        return binding.root
    }

    private fun guardarRegistro() {

        val nombRl = binding.itemNombRealUsuario.text.toString()
        val nombUs = binding.itemNombUser.text.toString()
        val pwd = binding.itemPasswordUser.text.toString()
        val email = binding.itemEmailUser.text.toString()

        if (nombRl.isNotEmpty() && nombUs.isNotEmpty() && pwd.isNotEmpty() && email.isNotEmpty())
        {
            //Crear objeto
            val usuar = Usuario(0,nombUs,pwd,nombRl,email,1)

            //Agregar nuevo usuario
            viewModel.agregarUsuario(usuar)
            Toast.makeText(requireContext(), "Registro guardado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.ir_nav_users)
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