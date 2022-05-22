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
import uca.ni.edu.kelani.adapter.CategoriaAdapter
import uca.ni.edu.kelani.adapter.ClienteAdapter
import uca.ni.edu.kelani.bd.viewmodel.CategoriaViewModel
import uca.ni.edu.kelani.databinding.FragmentCategoriaBinding


class CategoriaFragment : Fragment() {
    private lateinit var binding: FragmentCategoriaBinding
    private lateinit var viewModel: CategoriaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoriaBinding.inflate(layoutInflater)

        val adapter = CategoriaAdapter()
        val recyclerView = binding.rvCategoria

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProvider(this)[CategoriaViewModel::class.java]
        viewModel.listaCategoria.observe(viewLifecycleOwner) { cat ->
            adapter.setDataCategoria(cat)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddCategoria.setOnClickListener {
            findNavController().navigate(R.id.add_Categoria)
        }
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

}