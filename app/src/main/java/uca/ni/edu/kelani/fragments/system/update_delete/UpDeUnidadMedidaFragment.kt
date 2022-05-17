package uca.ni.edu.kelani.fragments.system.update_delete

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_up_unidadmedida.*
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.UnidadMedida
import uca.ni.edu.kelani.bd.viewmodel.UnidadMedidaViewModel

import uca.ni.edu.kelani.databinding.FragmentUpUnidadmedidaBinding

class UpDeUnidadMedidaFragment : Fragment() {
    lateinit var binding: FragmentUpUnidadmedidaBinding
    private val args by navArgs<UpDeUnidadMedidaFragmentArgs>()
    private lateinit var viewModel: UnidadMedidaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentUpUnidadmedidaBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(UnidadMedidaViewModel::class.java)
        with(binding) {

            itNombMedida.setText(args.currentUnidadMedida.nombre_unidad)
            itDescMedida.setText(args.currentUnidadMedida.abreviatura)

            btnModUnidad.setOnClickListener {

                GuardarCambios()
            }

            delUnidad.setOnClickListener {
                EliminarUnidad()
            }
        }
        //Agregar menu
        /*setHasOptionsMenu(true)*/
        return binding.root
    }
    private fun GuardarCambios() {

        val nomb = binding.itNombMedida.text.toString()
        val abr = binding.itDescMedida.text.toString()

        if(nomb.isNotEmpty() && abr.isNotEmpty())
        {
            //Crear el objeto
            val unidadMedida = UnidadMedida(args.currentUnidadMedida.id_unidad, nomb,abr,2)
            //Actualizar
            viewModel.actualizarMedida(unidadMedida)
            Toast.makeText(requireContext(), "Registro actualizado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_upDeUnidadMedidaFragment_to_nav_unidadesM)
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
    private fun EliminarUnidad() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") {_, _ ->

            val nomb = binding.itNombMedida.text.toString()
            val abr = binding.itDescMedida.text.toString()

            //Crear el objeto
            val unidadMedida = UnidadMedida(args.currentUnidadMedida.id_unidad, nomb,abr,3)
            //Eliminar
            viewModel.eliminarMedida(unidadMedida)
            Toast.makeText(requireContext(), "Registro eliminado satisfactoriamente...",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_upDeUnidadMedidaFragment_to_nav_unidadesM)

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
        alerta.setTitle("Desea eliminar ${args.currentUnidadMedida.nombre_unidad}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentUnidadMedida.nombre_unidad}?")
        alerta.create().show()
    }
}