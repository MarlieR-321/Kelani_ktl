package uca.ni.edu.kelani.fragments.system.update_delete

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Usuario
import uca.ni.edu.kelani.bd.viewmodel.ClienteViewModel
import uca.ni.edu.kelani.bd.viewmodel.UsuarioViewModel
import uca.ni.edu.kelani.databinding.FragmentUpDeClienteBinding
import uca.ni.edu.kelani.databinding.FragmentUpDeUsersBinding


class UpDeUsersFragment : Fragment() {
    lateinit var binding: FragmentUpDeUsersBinding
    private val args by navArgs<UpDeUsersFragmentArgs>()
    private lateinit var viewModel: UsuarioViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentUpDeUsersBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(UsuarioViewModel::class.java)
        with(binding) {

            itemNombRealUsuario.setText(args.currentUsuario.nombre_real)
            itemNombUser.setText(args.currentUsuario.username)
            itemPasswordUser.setText(args.currentUsuario.pwd)
            itemEmailUser.setText(args.currentUsuario.email)

            btnModUser.setOnClickListener {
                GuardarCambios()
            }

            delUser.setOnClickListener {
                //EliminarUsuario()
            }
        }
        //Agregar menu
        /*setHasOptionsMenu(true)*/
        return binding.root
    }
    private fun GuardarCambios() {
        val nombRl = binding.itemNombRealUsuario.text.toString()
        val nombUs = binding.itemNombUser.text.toString()
        val pwd = binding.itemPasswordUser.text.toString()
        val email = binding.itemEmailUser.text.toString()

        if(nombRl.isNotEmpty() && nombUs.isNotEmpty() && pwd.isNotEmpty() && email.isNotEmpty())
        {
            //Crear el objeto
            val usuar = Usuario(args.currentUsuario.id_usuario, nombUs,pwd,nombRl,email,2)
            //Actualizar
            viewModel.actualizarUsuario(usuar)
            Toast.makeText(requireContext(), "Registro actualizado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.nav_users)
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
    private fun EliminarUsuario() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarUsuario(args.currentUsuario)
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
        alerta.setTitle("Desea eliminar ${args.currentUsuario.username}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentUsuario.username}?")
        alerta.create().show()
    }
}