package uca.ni.edu.kelani.network.response

import kotlinx.serialization.SerialName
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.UnidadMedida

class UnidadMedidaResponse (
    @SerialName(value = "id_unidad")
    val id_unidad:Int,
    @SerialName(value = "nombre")
    val nombre :String,
    @SerialName(value = "abreviatura")
    val abreviatura:String,
    @SerialName(value = "estado")
    val estado: Int
){
    fun toUnity() : UnidadMedida =
        UnidadMedida(id_unidad, nombre,abreviatura , estado)
}

