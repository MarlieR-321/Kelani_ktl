package uca.ni.edu.kelani.fragments.system.update_delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import uca.ni.edu.kelani.bd.viewmodel.ProductoViewModel
import uca.ni.edu.kelani.databinding.FragmentUpDelProductoBinding


class UpDelProductoFragment : Fragment() {

    lateinit var binding: FragmentUpDelProductoBinding
    private val args by navArgs<UpDelProductoFragmentArgs>()
    private lateinit var viewModel: ProductoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentUpDelProductoBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)
        with(binding){
            itNombreProducto.setText(args.currentProducto.nombre_producto)
            itDescripcionProducto.setText(args.currentProducto.descripcion)
            itPrecioProducto.setText(args.currentProducto.precio.toString())
            itCostoProducto.setText(args.currentProducto.costo.toString())
            //spCategoria.setSelection(args.currentProducto.id_categoria)
            itDescripcionCategoeria.setText(args.currentProducto.descripcion_categoria)
            //spUnidad
            itAbreviacionUnidad.setText(args.currentProducto.abreviatura)



            edit.setOnClickListener{
                GuardarCambios()
            }

            del.setOnClickListener{
                EliminarProducto()
            }

        }
        return binding.root



    }

    private fun GuardarCambios(){

    }

    private fun EliminarProducto(){

    }



}