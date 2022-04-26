package uca.ni.edu.kelani.fragments.system.agregar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.databinding.FragmentAgregarUsuarioBinding

class AgregarUsuarioFragment : Fragment() {
    private  lateinit var  binding: FragmentAgregarUsuarioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgregarUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGuardarUser.setOnClickListener {
            findNavController().navigate(R.id.action_agregarUsuarioFragment_to_nav_users)
        }
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

}