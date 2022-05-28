package uca.ni.edu.kelani.fragments.inicio

import android.content.IntentSender
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.databinding.FragmentPresetacionBinding
import java.util.*

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

        tiempo()

        /*binding.buttonSecond.setOnClickListener {
            *//*val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)*//*
            findNavController().navigate(R.id.action_PresentacionFragment_to_InicioSesionFragment)
        }*/
    }

    private fun tiempo() {
        var miliseg = 2000
        object : CountDownTimer(miliseg.toLong(), 1000){
            override fun onFinish(){
                findNavController().navigate(R.id.action_PresentacionFragment_to_InicioSesionFragment)
                this.cancel()
            }
            override fun onTick(millisUtilsFinished: Long){

            }
        }.start()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}