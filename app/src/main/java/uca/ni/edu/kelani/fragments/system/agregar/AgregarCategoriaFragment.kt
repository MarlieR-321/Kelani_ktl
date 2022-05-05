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
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.viewmodel.CategoriaViewModel
import uca.ni.edu.kelani.bd.viewmodel.ClienteViewModel
import uca.ni.edu.kelani.databinding.FragmentAgregarCategoriaBinding
import uca.ni.edu.kelani.databinding.FragmentAgregarClientesBinding

class AgregarCategoriaFragment : Fragment() {
    private lateinit var binding: FragmentAgregarCategoriaBinding

    private lateinit var viewModel: CategoriaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgregarCategoriaBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(CategoriaViewModel::class.java)
        binding.btnGuardarCategoria.setOnClickListener {
            guardarRegistro()
        }
        return binding.root

    }

    private fun guardarRegistro() {

        val nomb = binding.itemNombCategoria.text.toString()
        val desc = binding.itemDescripcion.text.toString()


        if (nomb.isNotEmpty()  && desc.isNotEmpty()) {
            //Crear objeto
            val category = Categoria(0, nomb,  desc, 1)

            //Agregar nueva Categoria
            viewModel.agregarCategoria(category)
            Toast.makeText(
                requireContext(), "Registro guardado",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.ir_a_nav_category)
        } else {
            Toast.makeText(requireContext(), "Debe rellenar todos los campos", Toast.LENGTH_LONG)
                .show()
        }
    }


        /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.btnGuardarCategoria.setOnClickListener {
                findNavController().navigate(R.id.action_agregarCategoriaFragment_to_nav_Category)
            }
        }*/
}