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
import uca.ni.edu.kelani.adapter.FacturaEncAdapter
import uca.ni.edu.kelani.adapter.ProductoAdapter
import uca.ni.edu.kelani.bd.viewmodel.FacturaViewModel
import uca.ni.edu.kelani.bd.viewmodel.ProductoViewModel
import uca.ni.edu.kelani.databinding.FragmentFacturacionBinding
import uca.ni.edu.kelani.databinding.FragmentProductosBinding

class ProductosFragment : Fragment(){

    private lateinit var binding: FragmentProductosBinding
    private lateinit var viewModel: ProductoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductosBinding.inflate(layoutInflater)

        val adapter = ProductoAdapter()
        val recyclerView = binding.rvProductos

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProvider(this)[ProductoViewModel::class.java]
        viewModel.listaProducto.observe(viewLifecycleOwner, Observer {
                product->adapter.setDataProducto(product)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.agregarProductosFragment)
        }
    }

}