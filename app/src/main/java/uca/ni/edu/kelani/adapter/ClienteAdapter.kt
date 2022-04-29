package uca.ni.edu.kelani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaEnc
import uca.ni.edu.kelani.databinding.ItemClienteBinding
import uca.ni.edu.kelani.databinding.ItemFacturaBinding

class ClienteAdapter( var lista: List<Cliente>): RecyclerView.Adapter<ClienteAdapter.ClienteHolder>() {


    inner class ClienteHolder(val binding: ItemClienteBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(cl: Cliente){

            with(binding){
                itemIdClientes.text = cl.id_cliente.toString()
                itemNombClientes.text = cl.nombre
                itemApellClientes.text = cl.apellido
                itemTelefClientes.text = cl.telefono
                itemCedulaClientes.text = cl.cedula
                itemDireccionClientes.text = cl.direccion

                ivEditCliente.setOnClickListener {
                    it.findNavController().navigate(R.id.upDeClienteFragment)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteHolder {
        val binding = ItemClienteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ClienteHolder(binding)
    }

    override fun onBindViewHolder(holder: ClienteAdapter.ClienteHolder, position: Int) {
        holder.bind(
            lista[position]
        )
    }

    override fun getItemCount(): Int =lista.size
}