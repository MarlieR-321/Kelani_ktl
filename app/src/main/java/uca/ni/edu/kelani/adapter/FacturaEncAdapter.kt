package uca.ni.edu.kelani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.databinding.ItemFacturaBinding

class FacturaEncAdapter():RecyclerView.Adapter<FacturaEncAdapter.FacturaEncHolder>() {
    var lista: List<vw_Factura> = emptyList()

    inner class FacturaEncHolder(val binding: ItemFacturaBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(fe: vw_Factura){

            with(binding){
                itemIdFactura.text = fe.id_factura.toString()
                itemDireccionClientes.text = fe.direccion
                itemNombClientes.text = fe.nombre_cliente
                itemTelefClientes.text = fe.telefono
                txtTotal.text = fe.total.toString()
                txtFecha.text = fe.fecha

                ivEdit.setOnClickListener {
                    it.findNavController().navigate(R.id.upDelFacturaFragment)
                }
                ivDetalles.setOnClickListener {
                    it.findNavController().navigate(R.id.facturacionDetFragment)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacturaEncHolder {
        val binding = ItemFacturaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FacturaEncHolder(binding)
    }
    fun setDataFactura(f: List<vw_Factura>) {
        this.lista = f
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: FacturaEncHolder, position: Int) {
        holder.bind(
            lista[position]
        )
    }

    override fun getItemCount(): Int =lista.size
}