package uca.ni.edu.kelani.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import uca.ni.edu.kelani.network.requests.UsuarioRequest
import uca.ni.edu.kelani.network.requests.UsuarioUpRequest

@Parcelize
@Entity(tableName="Usuario")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id_usuario:Int,
    @ColumnInfo(name="username")
    val username:String,
    @ColumnInfo(name="pwd")
    val pwd:String,
    @ColumnInfo(name="nombre_real")
    val nombre_real:String,
    @ColumnInfo(name="email")
    val email:String,
    @ColumnInfo(name="estado")
    val estado:Int
    ):Parcelable{
    fun toUsuarioRequest(): UsuarioRequest
            = UsuarioRequest(username, pwd, nombre_real, email, estado)

    fun toUsuarioUpRequest(): UsuarioUpRequest
            = UsuarioUpRequest(id_usuario, username, pwd, nombre_real, email, estado)
        }