package uca.ni.edu.kelani.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import uca.ni.edu.kelani.network.requests.FacturaDetRequest

@Parcelize
@Entity(tableName="FacturaDet",
        foreignKeys = [
            ForeignKey(entity = Producto::class, parentColumns = ["id_producto"], childColumns = ["id_producto"]),
            ForeignKey(entity = Factura::class, parentColumns = ["id_factura"], childColumns = ["id_factura"])
        ])
data class FacturaDet(
    @PrimaryKey(autoGenerate = true)
    val id_factura_det:Int,
    @ColumnInfo(name="id_factura")
    val id_factura:Int,
    @ColumnInfo(name="id_producto")
    val id_producto:Int,
    @ColumnInfo(name="cantidad")
    val cantidad:Int,
    @ColumnInfo(name="subtotal")
    val subtotal:Double,
    @ColumnInfo(name="estado")
    val estado:Int
):Parcelable{
    fun toRequest():FacturaDetRequest
        = FacturaDetRequest(id_factura,id_producto, cantidad, subtotal, estado)
}