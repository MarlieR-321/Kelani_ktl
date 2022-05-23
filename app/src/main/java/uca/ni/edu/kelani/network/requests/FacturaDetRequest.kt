package uca.ni.edu.kelani.network.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FacturaDetRequest(
    @SerialName(value="id_factura")
    val id_factura:Int,
    @SerialName(value="id_producto")
    val id_producto:Int,
    @SerialName(value="cantidad")
    val cantidad:Int,
    @SerialName(value="subtotal")
    val subtotal:Double,
    @SerialName(value="estado")
    val estado:Int
)
