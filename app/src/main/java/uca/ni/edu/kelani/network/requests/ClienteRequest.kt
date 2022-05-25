package uca.ni.edu.kelani.network.requests

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName

 data class ClienteRequest (
    @SerialName(value = "nombre")
    @Expose
    val nombre:String,

    @SerialName(value = "apellido")
    @Expose
    val apellido:String,

    @SerialName(value = "telefono")
    @Expose
    val telefono:String,

    @SerialName(value = "cedula")
    @Expose
    val cedula:String,

    @SerialName(value = "direccion")
    @Expose
    val direccion:String,

    @SerialName(value = "email")
    @Expose
    val email:String,

    @SerialName(value = "estado")
    @Expose
    val estado: Int
 )