package uca.ni.edu.kelani.fragments.system

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uca.ni.edu.kelani.databinding.FragmentFacturacionBinding
import uca.ni.edu.kelani.databinding.FragmentInicioSecionBinding


class FacturacionFragment : Fragment() {
    private lateinit var binding:FragmentFacturacionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFacturacionBinding.inflate(inflater, container, false)
        return binding.root
    }


}