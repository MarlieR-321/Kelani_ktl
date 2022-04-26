package uca.ni.edu.kelani.fragments.system.agregar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.databinding.FragmentAgregarCategoriaBinding

class AgregarCategoriaFragment : Fragment() {
    private lateinit var binding: FragmentAgregarCategoriaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgregarCategoriaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGuardarCategoria.setOnClickListener {
            findNavController().navigate(R.id.action_agregarCategoriaFragment_to_categoriaFragment2)
        }
    }
}