package uca.ni.edu.kelani.network.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uca.ni.edu.kelani.bd.entidades.Usuario

@Serializable
data class UsuarioUpRequest (
    @SerialName(value = "id_cliente")
    val id_cliente:Int,
    @SerialName(value = "username")
    val username:String,
    @SerialName(value = "pwd")
    val pwd:String,
    @SerialName(value = "nombre_real")
    val nombre_real:String,
    @SerialName(value = "email")
    val email:String,
    @SerialName(value = "estado")
    val estado: Int
    ){
    fun toUsuario() : Usuario =
        Usuario(id_cliente, username, pwd, nombre_real, email, estado)
}