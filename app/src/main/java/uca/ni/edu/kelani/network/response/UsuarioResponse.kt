package uca.ni.edu.kelani.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uca.ni.edu.kelani.bd.entidades.Usuario


@Serializable
data class UsuarioResponse(
    @SerialName(value = "id_usuario")
    val id_usuario:Int,
    @SerialName(value = "username")
    val username:String,
    @SerialName(value = "pwd")
    val pwd:String,
    @SerialName(value = "nombre_real")
    val nombre_real:String,
    @SerialName(value = "email")
    val email:String,
    @SerialName(value = "estado")
    val estado:Int
){
    fun toUsuario() : Usuario =
        Usuario(id_usuario, username,pwd,nombre_real,email,estado)
}
