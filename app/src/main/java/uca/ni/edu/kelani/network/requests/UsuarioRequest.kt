package uca.ni.edu.kelani.network.requests

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName

data class UsuarioRequest(
    @SerialName(value = "username")
    @Expose
    val username:String,

    @SerialName(value = "pwd")
    @Expose
    val pwd:String,

    @SerialName(value = "nombre_real")
    @Expose
    val nombre_real:String,

    @SerialName(value = "email")
    @Expose
    val email:String,

    @SerialName(value = "estado")
    @Expose
    val estado: Int
)
