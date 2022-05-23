package uca.ni.edu.kelani.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.Factura
import uca.ni.edu.kelani.bd.entidades.FacturaDet
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet
import uca.ni.edu.kelani.bd.viewmodel.FacturaDetViewModel
import uca.ni.edu.kelani.bd.viewmodel.FacturaViewModel
import uca.ni.edu.kelani.databinding.ItemFacturaBinding
import uca.ni.edu.kelani.fragments.system.listar.FacturacionFragmentDirections

class FacturaEncAdapter(val context: Context, val viewModel: FacturaViewModel, private val viewModelDet: FacturaDetViewModel):RecyclerView.Adapter<FacturaEncAdapter.FacturaEncHolder>() {
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
                ivDelete.setOnClickListener {
                    eliminarDets(initFactura(fe))
                }
            }
        }
    }

    private fun initFactura(vw: vw_Factura): Factura {
        return Factura(vw.id_factura,
            vw.fecha,
            vw.id_cliente,
            vw.telefono,
            vw.direccion,
            vw.total,
            1)
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

    private fun eliminarDets(fc:Factura) {
        val alerta = AlertDialog.Builder(context)
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarFactura(fc)
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
        alerta.setMessage("¿Esta seguro de eliminar la factura permanentemente?")
        alerta.create().show()


    }
}