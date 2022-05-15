package uca.ni.edu.kelani.fragments.system.update_delete

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_up_categoria.*
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.bd.viewmodel.CategoriaViewModel

import uca.ni.edu.kelani.databinding.FragmentUpCategoriaBinding

class UpDeCategoriaFragment : Fragment () {

    lateinit var binding: FragmentUpCategoriaBinding
    private val args by navArgs<UpDeCategoriaFragmentArgs>()
    private lateinit var viewModel: CategoriaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentUpCategoriaBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(CategoriaViewModel::class.java)
        with(binding) {

            itNombCategoria.setText(args.currentCategoria.nombre_categoria)
            itDescCategoria.setText(args.currentCategoria.descripcion)

            btnModCategoria.setOnClickListener {
                GuardarCambios()
            }

            delCategoria.setOnClickListener {
                EliminarCategoria()
            }
        }

        return binding.root
    }
    private fun GuardarCambios() {
        val nomb = binding.itNombCategoria.text.toString()
        val desc = binding.itDescCategoria.text.toString()


        if(nomb.isNotEmpty() && desc.isNotEmpty() )
        {
            //Crear el objeto
            val category = Categoria(args.currentCategoria.id_categoria, nomb,desc,2)
            //Actualizar
            viewModel.actualizarCategoria(category)
            Toast.makeText(requireContext(), "Registro actualizado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.nav_category)
        }
        else
        {
            Toast.makeText(requireContext(), "Debe rellenar todos los campos", Toast.LENGTH_LONG).show()
        }
    }


    /*override fun onCreateOptionsMenu(menu: Menu, inflater:
    MenuInflater
    ) {
        inflater.inflate(R.menu.delete_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarClasificacion()
        }
        return super.onOptionsItemSelected(item)
    }*/

    //Proximamente se desarrollara eliminar
    private fun EliminarCategoria() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") {_, _ ->

            val nomb = binding.itNombCategoria.text.toString()
            val desc  = binding.itDescCategoria.text.toString()


            //Crear el objeto
            val category = Categoria(args.currentCategoria.id_categoria, nomb,desc,3)
            //Eliminar
            viewModel.eliminarCategoria(category)
            Toast.makeText(requireContext(), "Registro eliminado satisfactoriamente...",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.nav_category)

            /* _, _ ->
         viewModel.eliminarCliente(args.currentCliente)
         Toast.makeText(
             requireContext(),
             "Registro eliminado satisfactoriamente...",
             Toast.LENGTH_LONG
         ).show()
         findNavController().navigate(R.id.nav_clients)*/
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Desea eliminar ${args.currentCategoria.nombre_categoria}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentCategoria.nombre_categoria}?")
        alerta.create().show()
    }
}