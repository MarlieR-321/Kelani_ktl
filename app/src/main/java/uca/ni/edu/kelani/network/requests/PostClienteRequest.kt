package uca.ni.edu.kelani.network.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostClienteRequest(
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