package uca.ni.edu.kelani.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uca.ni.edu.kelani.bd.entidades.views.vw_Producto

@Serializable
data class Vw_ProductoResponse (
    @SerialName(value = "id_producto")
    val id_producto: Int,
    @SerialName(value = "nombre_producto")
    val nombre_producto: String,
    @SerialName(value = "descripcion")
    val descripcion: String,
    @SerialName(value = "precio")
    val precio: Double,
    @SerialName(value = "costo")
    val costo: Double,
    @SerialName(value = "id_unidad")
    val id_unidad: Int,
    @SerialName(value = "nombre_unidad")
    val nombre_unidad: String,
    @SerialName(value = "abreviacion")
    val abreviacion: String,
    @SerialName(value = "id_categoria")
    val id_categoria: Int,
    @SerialName(value = "nombre_categoria")
    val nombre_categoria: String,
    @SerialName(value = "descripcion_categoria")
    val descripcion_categoria: String
        )
{
    fun toVwProducto() : vw_Producto =
        vw_Producto(id_producto,nombre_producto,descripcion,precio,costo,id_unidad,nombre_unidad,abreviacion,id_categoria,nombre_categoria, descripcion_categoria)
}