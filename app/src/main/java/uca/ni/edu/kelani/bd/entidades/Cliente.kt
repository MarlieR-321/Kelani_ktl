package uca.ni.edu.kelani.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="Cliente")
data class Cliente (
    @PrimaryKey(autoGenerate = true)
    val id_cliente:Int,
    @ColumnInfo(name="nombre")
    val nombre:String,
    @ColumnInfo(name="apellido")
    val apellido:String,
    @ColumnInfo(name="telefono")
    val telefono:String,
    @ColumnInfo(name="cedula")
    val cedula:String,
    @ColumnInfo(name="direccion")
    val direccion:String,
    @ColumnInfo(name="estado")
    val estado: Int
    ):Parcelable