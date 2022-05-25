package uca.ni.edu.kelani.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet

@Serializable
data class VwFacturaDetResponse(
    @SerialName(value = "id_fac_detalle")
    val id_fac_detalle:Int,
    @SerialName(value = "id_producto")
    val id_producto:Int,
    @SerialName(value = "id_factura")
    val id_factura:Int,
    @SerialName(value = "producto")
    val producto:String,
    @SerialName(value = "precio")
    val precio:Double,
    @SerialName(value = "cantidad")
    val cantidad:Int,
    @SerialName(value = "subtotal")
    val subtotal:Double
){
    fun toVwFacturaDet() : vw_FacturaDet =
            vw_FacturaDet(id_fac_detalle,id_producto,id_factura,producto,precio,cantidad,subtotal)

}
