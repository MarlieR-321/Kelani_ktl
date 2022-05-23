package uca.ni.edu.kelani.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import uca.ni.edu.kelani.network.request.FacturaRequest

@Parcelize
@Entity(tableName="Factura",
        foreignKeys = [
            ForeignKey(entity = Cliente::class, parentColumns = ["id_cliente"], childColumns = ["id_cliente"])
        ])
data class Factura(
    @PrimaryKey(autoGenerate = true)
    val id_factura:Int,
    @ColumnInfo(name="fecha")
    val fecha:String,
    @ColumnInfo(name="id_cliente")
    val id_cliente:Int,
    @ColumnInfo(name="telefono")
    val telefono:String,
    @ColumnInfo(name="direccion")
    val direccion:String,
    @ColumnInfo(name="total")
    val total:Double,
    @ColumnInfo(name="estado")
    val estado:Int
):Parcelable{
    fun toFacturaResponse(): FacturaRequest
        = FacturaRequest(estado, fecha, total, id_cliente, telefono, direccion)
}