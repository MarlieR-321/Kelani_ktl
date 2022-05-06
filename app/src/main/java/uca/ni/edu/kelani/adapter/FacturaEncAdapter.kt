package uca.ni.edu.kelani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.databinding.ItemFacturaBinding
import uca.ni.edu.kelani.fragments.system.listar.FacturacionFragmentDirections

class FacturaEncAdapter():RecyclerView.Adapter<FacturaEncAdapter.FacturaEncHolder>() {
    var lista: List<vw_Factura> = emptyList()

    inner class FacturaEncHolder(val binding: ItemFacturaBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(fe: vw_Factura){

            with(binding){
                itemDireccionClientes.text = fe.direccion
                itemNombClientes.text = fe.nombre_cliente
                itemTelefClientes.text = fe.telefono
                txtTotal.text = fe.total.toString()
                txtFecha.text = fe.fecha

                ivDetalles.setOnClickListener {
                    val action = FacturacionFragmentDirections.navToFacDet(fe.id_factura)
                    it.findNavController().navigate(action)
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