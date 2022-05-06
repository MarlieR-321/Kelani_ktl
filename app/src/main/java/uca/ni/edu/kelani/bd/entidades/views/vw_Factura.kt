package uca.ni.edu.kelani.bd.entidades.views

import android.os.Parcelable
import androidx.room.DatabaseView
import kotlinx.android.parcel.Parcelize


@Parcelize
@DatabaseView("Select f.id_factura,f.fecha,f.id_cliente,c.nombre || ' ' ||c.apellido as nombre_cliente, f.telefono,f.direccion,(Select SUM(subtotal) from FacturaDet fd where fd.id_factura=f.id_factura) as total from Factura as f inner join Cliente c on c.id_cliente=f.id_cliente")
data class vw_Factura(
    val id_factura:Int,
    val fecha:String,
    val id_cliente:Int,
    val nombre_cliente:String,
    val telefono:String,
    val direccion:String,
    val total:Int
):Parcelable