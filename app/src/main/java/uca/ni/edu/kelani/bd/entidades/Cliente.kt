package uca.ni.edu.kelani.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import uca.ni.edu.kelani.network.requests.ClienteRequest
import uca.ni.edu.kelani.network.requests.ClienteUpRequest

@Parcelize
@Entity(tableName="Cliente")
data class Cliente (
    @PrimaryKey(autoGenerate = true)
    var id_cliente:Int,
    @ColumnInfo(name="nombre")
    var nombre:String,
    @ColumnInfo(name="apellido")
    var apellido:String,
    @ColumnInfo(name="telefono")
    var telefono:String,
    @ColumnInfo(name="cedula")
    var cedula:String,
    @ColumnInfo(name="direccion")
    var direccion:String,
    @ColumnInfo(name="email")
    val email:String,
    @ColumnInfo(name="estado")
    var estado: Int
    ):Parcelable{
    fun toClienteRequest(): ClienteRequest
            = ClienteRequest(nombre, apellido, telefono, cedula, direccion, email, estado)

    fun toClienteUpRequest(): ClienteUpRequest
            = ClienteUpRequest(id_cliente, nombre, apellido, telefono, cedula, direccion, email, estado)
    }