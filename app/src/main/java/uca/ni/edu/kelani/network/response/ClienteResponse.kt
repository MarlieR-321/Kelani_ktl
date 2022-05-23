package uca.ni.edu.kelani.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uca.ni.edu.kelani.bd.entidades.Cliente

@Serializable
data class ClienteResponse (
    @SerialName(value = "id_cliente")
    val id_cliente:Int,
    @SerialName(value = "nombre")
    val nombre:String,
    @SerialName(value = "apellido")
    val apellido:String,
    @SerialName(value = "telefono")
    val telefono:String,
    @SerialName(value = "cedula")
    val cedula:String,
    @SerialName(value = "direccion")
    val direccion:String,
    @SerialName(value = "estado")
    val estado: Int
)
    fun ClienteResponse.toModel() : Cliente =
        Cliente(id_cliente, nombre, apellido, telefono, cedula, direccion, estado)
