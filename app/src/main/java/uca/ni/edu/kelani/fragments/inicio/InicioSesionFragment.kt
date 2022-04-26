package uca.ni.edu.kelani.fragments.inicio

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uca.ni.edu.kelani.databinding.FragmentInicioSecionBinding
import uca.ni.edu.kelani.fragments.system.MainActivity

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InicioSesionFragment : Fragment() {

    private var _binding: FragmentInicioSecionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentInicioSecionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btIniciarSecion.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            //findNavController().navigate(R.id.action_InicioSesionFragment_to_PresentacionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}