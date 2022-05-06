package uca.ni.edu.kelani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet
import uca.ni.edu.kelani.databinding.ItemFacturaDetalleBinding

class FacturaDetAdapter():RecyclerView.Adapter<FacturaDetAdapter.FacturaDetHolder>() {
    var lista: List<vw_FacturaDet> = emptyList()

    inner class FacturaDetHolder(val binding: ItemFacturaDetalleBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(fd: vw_FacturaDet){

            with(binding){
                txtProd.text = fd.producto
                txtCantidad.text = fd.cantidad.toString()
                txtPrecio.text = fd.precio.toString()
                txtTotal.text = fd.subtotal.toString()

                ivDelete.setOnClickListener {
                    //Mandar delete de un solo
                    //it.findNavController().navigate(R.id.upDelFacturaDetFragment)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacturaDetHolder {
        val binding = ItemFacturaDetalleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FacturaDetHolder(binding)
    }

    fun setDataFactura(f: List<vw_FacturaDet>) {
        this.lista = f
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: FacturaDetHolder, position: Int) {
        holder.bind(
            lista[position]
        )
    }

    override fun getItemCount(): Int =lista.size
}