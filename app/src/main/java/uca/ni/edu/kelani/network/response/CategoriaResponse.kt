package uca.ni.edu.kelani.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uca.ni.edu.kelani.bd.entidades.Categoria

@Serializable
data class CategoriaResponse(
    @SerialName(value = "id_categoria")
    val id_categoria : Int,
    @SerialName(value = "nombre_categoria")
    val nombre_categoria : String,
    @SerialName(value = "descripcion")
    val descripcion : String,
    @SerialName(value = "estado")
    val estado : Int
) {
    fun toCategoria() : Categoria =
        Categoria(id_categoria, nombre_categoria, descripcion, estado)
}