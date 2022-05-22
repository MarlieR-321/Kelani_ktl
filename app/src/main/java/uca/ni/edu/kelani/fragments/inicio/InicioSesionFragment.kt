package uca.ni.edu.kelani.fragments.inicio

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.dao.UsuarioDao
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.viewmodel.UsuarioViewModel
import uca.ni.edu.kelani.databinding.FragmentInicioSecionBinding
import uca.ni.edu.kelani.fragments.system.MainActivity

class InicioSesionFragment : Fragment() {

    private lateinit var binding: FragmentInicioSecionBinding
    private lateinit var viewModel: UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentInicioSecionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btIniciarSecion.setOnClickListener {

            //verificacionUsuario(binding.itemUsuario.text.toString(), binding.itemPassword.text.toString())
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)

            //findNavController().navigate(R.id.action_InicioSesionFragment_to_PresentacionFragment)
        }
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

    fun verificacionUsuario(usur:String, pwd:String){
        val dbinstance = bdKealni.getDataBase(requireContext())
        val dao: UsuarioDao = dbinstance.usuarioDao()

        CoroutineScope(Dispatchers.Main).launch {
            if(dao.getVerif(usur,pwd) != null)
            {
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
        }


    }




}



