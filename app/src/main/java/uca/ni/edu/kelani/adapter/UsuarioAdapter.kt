package uca.ni.edu.kelani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Usuario
import uca.ni.edu.kelani.databinding.ItemClienteBinding
import uca.ni.edu.kelani.databinding.ItemUsuariosBinding
import uca.ni.edu.kelani.fragments.system.listar.ClienteFragmentDirections
import uca.ni.edu.kelani.fragments.system.listar.UsuariosFragmentDirections

class UsuarioAdapter(): RecyclerView.Adapter<UsuarioAdapter.UsuarioHolder>() {
    var lista: List<Usuario> = emptyList()

    inner class UsuarioHolder(val binding: ItemUsuariosBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(us: Usuario){

            with(binding){
                itemIdUsuarios.text = us.id_usuario.toString()
                itemNombUsuarios.text = us.username
                itemNombReal.text = us.nombre_real
                itemEmail.text = us.email


                llUsuarios.setOnClickListener {
                    val action= UsuariosFragmentDirections.navUsersToUpDeUsersFragment(us)
                    it.findNavController().navigate(action)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioAdapter.UsuarioHolder {
        val binding = ItemUsuariosBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UsuarioHolder(binding)
    }

    fun setDataUsuario(us: List<Usuario>) {
        this.lista = us
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UsuarioAdapter.UsuarioHolder, position: Int) {
        holder.bind(
            lista[position]
        )
    }

    override fun getItemCount(): Int =lista.size
}