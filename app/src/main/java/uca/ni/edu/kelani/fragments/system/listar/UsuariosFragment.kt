package uca.ni.edu.kelani.fragments.system.listar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.adapter.ClienteAdapter
import uca.ni.edu.kelani.adapter.UsuarioAdapter
import uca.ni.edu.kelani.bd.viewmodel.ClienteViewModel
import uca.ni.edu.kelani.bd.viewmodel.UsuarioViewModel
import uca.ni.edu.kelani.databinding.FragmentClienteBinding
import uca.ni.edu.kelani.databinding.FragmentUsuariosBinding


class UsuariosFragment : Fragment() {
    private lateinit var binding: FragmentUsuariosBinding
    private lateinit var viewModel: UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUsuariosBinding.inflate(layoutInflater)

        val adapter = UsuarioAdapter()
        val recyclerView = binding.rvUsuarios

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProvider(this)[UsuarioViewModel::class.java]
        viewModel.listaUsuario.observe(viewLifecycleOwner, Observer {
                usu->adapter.setDataUsuario(usu)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addUsuario)
        }
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

}