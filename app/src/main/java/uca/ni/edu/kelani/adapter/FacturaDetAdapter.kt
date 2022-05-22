package uca.ni.edu.kelani.adapter

import android.app.AlertDialog
import android.app.Application
import android.app.ApplicationErrorReport
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.FacturaDet
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet
import uca.ni.edu.kelani.bd.viewmodel.FacturaDetViewModel
import uca.ni.edu.kelani.databinding.ItemFacturaDetalleBinding
import uca.ni.edu.kelani.fragments.system.listar.FacturacionDetFragmentDirections
import java.lang.Exception

class FacturaDetAdapter(var lista: ArrayList<vw_FacturaDet>, val context:Context, val viewModel: FacturaDetViewModel):RecyclerView.Adapter<FacturaDetAdapter.FacturaDetHolder>() {
    //var lista: List<vw_FacturaDet> = emptyList()

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
                    eliminar(initFactura(fd))
                }
            }
        }
    }

    private fun initFactura(vw: vw_FacturaDet): FacturaDet {
        return FacturaDet(vw.id_factura_det,
            vw.id_factura,
            vw.id_producto,
            vw.cantidad,
            vw.subtotal,
            1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacturaDetHolder {
        val binding = ItemFacturaDetalleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FacturaDetHolder(binding)
    }

    fun setDataFactura(f: ArrayList<vw_FacturaDet>) {
        this.lista = f
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: FacturaDetHolder, position: Int) {
        holder.bind(
            lista[position]
        )
    }

    override fun getItemCount(): Int =lista.size

    private fun eliminar(fd:FacturaDet) {
        val alerta = AlertDialog.Builder(context)
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarFacturaDet(fd)
            Toast.makeText(
                context,
                "Registro eliminado satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                context,
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }

        alerta.setTitle("Eliminación solicitada")
        alerta.setMessage("¿Esta seguro de eliminar el registro permanentemente?")
        alerta.create().show()


    }
}