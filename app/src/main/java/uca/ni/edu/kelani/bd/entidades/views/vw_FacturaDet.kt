package uca.ni.edu.kelani.bd.entidades.views

import android.os.Parcelable
import androidx.room.DatabaseView
import kotlinx.android.parcel.Parcelize

@Parcelize
@DatabaseView("Select fd.id_factura_det,fd.id_producto,fd.id_factura,p.nombre as producto, p.precio,fd.cantidad, fd.subtotal " +
                    "from FacturaDet as fd " +
                    "inner join Producto as p on p.id_producto=fd.id_producto")
data class vw_FacturaDet(
    val id_factura_det:Int,
    val id_producto:Int,
    val id_factura:Int,
    val producto:String,
    val precio:Double,
    val cantidad:Int,
    val subtotal:Double
):Parcelable