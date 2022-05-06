package uca.ni.edu.kelani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.kelani.bd.entidades.views.vw_Producto
import uca.ni.edu.kelani.databinding.ItemFacturaBinding
import uca.ni.edu.kelani.databinding.ItemProductosBinding
import uca.ni.edu.kelani.fragments.system.listar.FacturacionFragmentDirections
import uca.ni.edu.kelani.fragments.system.listar.ProductosFragmentDirections

class ProductoAdapter(): RecyclerView.Adapter<ProductoAdapter.ProductoHolder>() {
    var lista: List<vw_Producto> = emptyList()

    inner class ProductoHolder(val binding: ItemProductosBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(producto: vw_Producto){

            with(binding){
                itemNombProducto.text = producto.nombre_producto
                itemDescripcion.text = producto.descripcion
                itemPrecio.text = producto.precio.toString()
                itemCosto.text = producto.costo.toString()
                itemUnidad.text = producto.nombre_unidad
                itemUnidadAbreviacion.text = producto.abreviatura
                itemCategoria.text = producto.nombre_categoria
                itemCategoriaDescripcion.text = producto.descripcion_categoria

                ivDetalles.setOnClickListener {
                    val action = ProductosFragmentDirections.irUpDelProducto(producto.id_producto)
                    it.findNavController().navigate(action)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoHolder {
        val binding = ItemProductosBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductoHolder(binding)
    }
    fun setDataProducto(producto: List<vw_Producto>){
        this.lista = producto
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ProductoHolder, position: Int) {
        holder.bind(
            lista[position]
        )
    }

    override fun getItemCount(): Int =lista.size
}