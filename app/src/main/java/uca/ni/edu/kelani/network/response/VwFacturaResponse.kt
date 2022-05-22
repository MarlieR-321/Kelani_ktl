package uca.ni.edu.kelani.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura

@Serializable
data class VwFacturaResponse(
    @SerialName(value = "id_factura")
    val id_factura:Int,
    @SerialName(value = "fecha")
    val fecha:String,
    @SerialName(value = "id_cliente")
    val id_cliente:Int,
    @SerialName(value = "nombre_cliente")
    val nombre_cliente:String,
    @SerialName(value = "telefono")
    val telefono:String,
    @SerialName(value = "direccion")
    val direccion:String,
    @SerialName(value = "total")
    val total:Double
){
    fun toVwFactura() : vw_Factura =
        vw_Factura(id_factura,fecha,id_cliente,nombre_cliente,telefono,direccion,total)

}
