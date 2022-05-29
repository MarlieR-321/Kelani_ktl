package uca.ni.edu.kelani.network.requests

import kotlinx.serialization.SerialName
import uca.ni.edu.kelani.bd.entidades.Categoria

class CategoriaUpRequest (

    @SerialName(value = "id_categoria")
    val id_categoria:Int,
    @SerialName(value = "nombre_categoria")
    val nombre_categoria :String,
    @SerialName(value = "descripcion")
    val descripcion:String,
    @SerialName(value = "estado")
    val estado: Int
    ){
        fun toCategory() : Categoria =
            Categoria(id_categoria, nombre_categoria, descripcion, estado)
    }


