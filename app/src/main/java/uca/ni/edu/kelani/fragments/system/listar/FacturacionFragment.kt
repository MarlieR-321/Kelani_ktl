package uca.ni.edu.kelani.fragments.system.listar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.adapter.FacturaEncAdapter
import uca.ni.edu.kelani.bd.viewmodel.FacturaDetViewModel
import uca.ni.edu.kelani.bd.viewmodel.FacturaViewModel
import uca.ni.edu.kelani.databinding.FragmentFacturacionBinding


class FacturacionFragment : Fragment() {
    private lateinit var binding:FragmentFacturacionBinding
    private lateinit var viewModel: FacturaViewModel
    private lateinit var viewModelDet: FacturaDetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFacturacionBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[FacturaViewModel::class.java]
        viewModelDet = ViewModelProvider(this)[FacturaDetViewModel::class.java]

        val adapter = FacturaEncAdapter(requireContext(),viewModel,viewModelDet)
        val recyclerView = binding.rvFacturas

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.listaFactura.observe(viewLifecycleOwner){
            adapter.setDataFactura(it)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addFacturaFragment)
        }
    }


}