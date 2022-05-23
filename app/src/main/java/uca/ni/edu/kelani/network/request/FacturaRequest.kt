package uca.ni.edu.kelani.network.request

import com.google.gson.annotations.Expose
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.sql.Date


@Serializable
data class FacturaRequest(
    @SerialName(value="estado")
    @Expose
    val estado:Int,

    @SerialName(value="fecha")
    @Expose
    val fecha:String,

    @SerialName(value="total")
    @Expose
    val total:Double,

    @SerialName(value="id_cliente")
    @Expose
    val id_cliente:Int,

    @SerialName(value="telefono")
    @Expose
    val telefono:String,

    @SerialName(value="direccion")
    @Expose
    val direccion:String,
    )
