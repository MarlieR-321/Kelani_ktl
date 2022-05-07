package uca.ni.edu.kelani.fragments.system.listar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.adapter.FacturaDetAdapter
import uca.ni.edu.kelani.adapter.FacturaEncAdapter
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet
import uca.ni.edu.kelani.bd.viewmodel.FacturaDetViewModel
import uca.ni.edu.kelani.bd.viewmodel.FacturaViewModel
import uca.ni.edu.kelani.databinding.FragmentFactutacionDetBinding

// TODO: Rename parameter arguments, choose names that match

class FacturacionDetFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding: FragmentFactutacionDetBinding
    private val args by navArgs<FacturacionDetFragmentArgs>()
    private lateinit var viewModel: FacturaDetViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFactutacionDetBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[FacturaDetViewModel::class.java]


        val adapter = FacturaDetAdapter(requireContext(),viewModel)
        val recyclerView = binding.rvFacturas

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.listarById(args.id).observe(viewLifecycleOwner, Observer {
                fac->adapter.setDataFactura(fac)
        })

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            val action = FacturacionDetFragmentDirections.facturaDetToAdd(args.id)
            it.findNavController().navigate(action)
        }
    }
}