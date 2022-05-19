package uca.ni.edu.kelani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.UnidadMedida
import uca.ni.edu.kelani.databinding.ItemUnidadmedidaBinding
import uca.ni.edu.kelani.fragments.system.listar.UnidadmedidaFragmentDirections

class UnidadMedidaAdapter (): RecyclerView.Adapter<UnidadMedidaAdapter.UnidadMedidaHolder>() {
    var lista: List<UnidadMedida> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnidadMedidaHolder {
        val binding = ItemUnidadmedidaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UnidadMedidaHolder(binding)
    }

    override fun onBindViewHolder(holder: UnidadMedidaAdapter.UnidadMedidaHolder, position: Int) {
        holder.bind(
            lista[position]
        )
    }
    override fun getItemCount(): Int =lista.size

    fun setDataUnidadMedida(um: List<UnidadMedida>) {
        this.lista = um
        notifyDataSetChanged()
    }


    inner class UnidadMedidaHolder(val binding: ItemUnidadmedidaBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(um: UnidadMedida){

            with(binding){
                itemIdUnidadMedida.text = um.id_unidad.toString()
                itemNombUMedida.text = um.nombre_unidad
                itemAbreviatura.text = um.abreviatura


                llUnidadMedida.setOnClickListener {
                    val action =
                        UnidadmedidaFragmentDirections.actionNavUnidadesMToUpDeUnidadMedidaFragment(um)
                    it.findNavController().navigate(action)
                }

            }
        }
    }

}

