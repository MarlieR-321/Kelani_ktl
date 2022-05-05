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
import uca.ni.edu.kelani.adapter.FacturaEncAdapter
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.viewmodel.ClienteViewModel
import uca.ni.edu.kelani.bd.viewmodel.FacturaViewModel
import uca.ni.edu.kelani.databinding.FragmentClienteBinding


class ClienteFragment : Fragment() {
    private lateinit var  binding: FragmentClienteBinding
    private lateinit var viewModel:ClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentClienteBinding.inflate(layoutInflater)

        val adapter = ClienteAdapter()
        val recyclerView = binding.rvClientes

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProvider(this)[ClienteViewModel::class.java]
        viewModel.listaCliente.observe(viewLifecycleOwner, Observer {
                cli->adapter.setDataCliente(cli)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addCliente)
        }
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
    
}