package uca.ni.edu.kelani.network.response

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uca.ni.edu.kelani.bd.entidades.Factura


@Serializable
data class FacturaResponse (
    @SerialName(value="id_factura")
    val id_factura:Int,

    @SerialName(value="estado")
    val estado:Int,

    @SerialName(value="fecha")
    val fecha:String,

    @SerialName(value="total")
    val total:Double,

    @SerialName(value="id_cliente")
    val id_cliente:Int,

    @SerialName(value="telefono")
    val telefono:String,

    @SerialName(value="direccion")
    val direccion:String,
    )