package uca.ni.edu.kelani.fragments.system.update_delete

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.viewmodel.ClienteViewModel
import uca.ni.edu.kelani.databinding.FragmentAddFacturaBinding
import uca.ni.edu.kelani.databinding.FragmentUpDeClienteBinding
import uca.ni.edu.kelani.fragments.system.agregar.AddFacturaDetFragmentArgs
import uca.ni.edu.kelani.fragments.system.listar.FacturacionDetFragmentArgs


class UpDeClienteFragment : Fragment() {
    lateinit var binding: FragmentUpDeClienteBinding
    private val args by navArgs<UpDeClienteFragmentArgs>()
    private lateinit var viewModel: ClienteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentUpDeClienteBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(ClienteViewModel::class.java)
        with(binding) {

            itNombCliente.setText(args.currentCliente.nombre)
            itAapellCliente.setText(args.currentCliente.apellido)
            itTelefCliente.setText(args.currentCliente.telefono)
            itCedulaCliente.setText(args.currentCliente.cedula)
            itDireccionCliente.setText(args.currentCliente.direccion)
            itEmailCliente.setText(args.currentCliente.email)

            btnModClient.setOnClickListener {
                GuardarCambios()
            }

            delClient.setOnClickListener {
                EliminarCliente()
            }
        }
        //Agregar menu
        /*setHasOptionsMenu(true)*/
        return binding.root
    }
    private fun GuardarCambios() {
        val nomb = binding.itNombCliente.text.toString()
        val apell = binding.itAapellCliente.text.toString()
        val telef = binding.itTelefCliente.text.toString()
        val cedul = binding.itCedulaCliente.text.toString()
        val dir = binding.itDireccionCliente.text.toString()
        val email = binding.itEmailCliente.text.toString()


        if(nomb.isNotEmpty() && apell.isNotEmpty() && telef.isNotEmpty() && cedul.isNotEmpty() && dir.isNotEmpty())
        {
            //Crear el objeto
            val client = Cliente(args.currentCliente.id_cliente, nomb,apell,telef,cedul,dir,email,2)
            //Actualizar
            viewModel.updateCliente(client)
            Toast.makeText(requireContext(), "Registro actualizado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.nav_clients)
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
    private fun EliminarCliente() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") {_, _ ->

            /*val nomb = binding.itNombCliente.text.toString()
            val apell = binding.itAapellCliente.text.toString()
            val telef = binding.itTelefCliente.text.toString()
            val cedul = binding.itCedulaCliente.text.toString()
            val dir = binding.itDireccionCliente.text.toString()
            val email = binding.itEmailCliente.text.toString()

                //Crear el objeto
                val client = Cliente(args.currentCliente.id_cliente, nomb,apell,telef,cedul,dir,email,3)
                //Eliminar
                viewModel.eliminarCliente(client)
                Toast.makeText(requireContext(), "Registro eliminado satisfactoriamente...",
                    Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.nav_clients)*/


            viewModel.eliminarCliente(args.currentCliente)
            Toast.makeText(
                requireContext(),
                "Registro eliminado satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.nav_clients)
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Desea eliminar ${args.currentCliente.nombre}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentCliente.nombre}?")
        alerta.create().show()
    }
}