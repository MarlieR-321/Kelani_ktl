package uca.ni.edu.kelani

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uca.ni.edu.kelani.databinding.FragmentPresetacionBinding
import uca.ni.edu.kelani.fragments.system.MainActivity


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PresentacionFragment : Fragment() {

    private var _binding: FragmentPresetacionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentPresetacionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            /*val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)*/
            findNavController().navigate(R.id.action_PresentacionFragment_to_InicioSesionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}