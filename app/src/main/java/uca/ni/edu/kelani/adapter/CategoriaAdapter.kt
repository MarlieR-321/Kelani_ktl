package uca.ni.edu.kelani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.databinding.ItemCategoriaBinding
import uca.ni.edu.kelani.fragments.system.listar.CategoriaFragmentDirections

import uca.ni.edu.kelani.databinding.ItemClienteBinding

class CategoriaAdapter (): RecyclerView.Adapter<CategoriaAdapter.CategoriaHolder>() {
    var lista: List<Categoria> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaHolder {
        val binding = ItemCategoriaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoriaHolder(binding)
    }
    override fun onBindViewHolder(holder: CategoriaAdapter.CategoriaHolder, position: Int) {
        holder.bind(
            lista[position]
        )
    }
    override fun getItemCount(): Int = lista.size

    fun setDataCategoria(ct: List<Categoria>) {
        this.lista = ct
        notifyDataSetChanged()
    }




    inner class CategoriaHolder(val binding: ItemCategoriaBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(cat: Categoria){

            with(binding){
                itemIdCategoria.text = cat.id_categoria.toString()
                itemNombCategoria.text = cat.nombre_categoria
                itemDescripcion.text = cat.descripcion


                llCategoria.setOnClickListener {
                    val action =
                        CategoriaFragmentDirections.actionNavCategoryToUpDeCategoriaFragment(cat)
                    it.findNavController().navigate(action)
                }


            }
        }
    }

}
