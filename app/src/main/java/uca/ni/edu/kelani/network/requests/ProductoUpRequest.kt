package uca.ni.edu.kelani.network.requests

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uca.ni.edu.kelani.bd.entidades.Producto

@Serializable
data class ProductoUpRequest (

    @SerialName(value = "id_producto")
    val id_producto:Int,

    @SerialName(value="nombre")
    @Expose
    val nombre:String,

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

    @SerialName(value="id_categoria")
    @Expose
    val id_categoria:Int,

    @SerialName(value="estado")
    @Expose
    val estado:Int

){
    fun toProducto() : Producto =
        Producto(id_producto, id_unidad, id_categoria, nombre, descripcion, precio, costo, estado)
}