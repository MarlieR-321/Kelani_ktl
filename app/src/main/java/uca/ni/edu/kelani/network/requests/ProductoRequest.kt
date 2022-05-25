package uca.ni.edu.kelani.network.requests

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductoRequest (

    @SerialName(value="nombre_producto")
    @Expose
    val nombre_producto:String,

    @SerialName(value="descripcion")
    @Expose
    val descripcion:String,

    @SerialName(value="precio")
    @Expose
    val precio:Double,

    @SerialName(value="costo")
    @Expose
    val costo:Double,

    @SerialName(value="id_unidad")
    @Expose
    val id_unidad:Int,

    @SerialName(value="abreviacion")
    @Expose
    val abreviacion:String,

    @SerialName(value="id_categoria")
    @Expose
    val id_categoria:Int,

    @SerialName(value="descripcion_categoria")
    @Expose
    val descripcion_categoria:String,

    @SerialName(value="estado")
    @Expose
    val estado:Int

)