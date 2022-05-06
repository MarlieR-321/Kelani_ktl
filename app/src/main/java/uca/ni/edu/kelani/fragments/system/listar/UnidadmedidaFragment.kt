package uca.ni.edu.kelani.fragments.system.listar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.adapter.UnidadMedidaAdapter
import uca.ni.edu.kelani.bd.viewmodel.UnidadMedidaViewModel
import uca.ni.edu.kelani.databinding.FragmentUnidadMedidaBinding

class UnidadmedidaFragment : Fragment() {
    private  lateinit var  binding: FragmentUnidadMedidaBinding
    private lateinit var viewModel: UnidadMedidaViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUnidadMedidaBinding.inflate(inflater, container, false)

        val adapter = UnidadMedidaAdapter()
        val recyclerView = binding.rvUnidadMedida

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProvider(this)[UnidadMedidaViewModel::class.java]
        viewModel.listaUnidadMedida.observe(viewLifecycleOwner, Observer {
                um->adapter.setDataUnidadMedida(um)
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAgregarUnidad.setOnClickListener {
            findNavController().navigate(R.id.add_measure)
        }
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

}