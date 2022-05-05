package uca.ni.edu.kelani.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="Categoria")
data class Categoria(
    @PrimaryKey(autoGenerate = true)
    val id_categoria:Int,
    @ColumnInfo(name="nombre_categoria")
    val nombre_categoria:String,
    @ColumnInfo(name="descripcion")
    val descripcion:String,
    @ColumnInfo(name="estado")
    val estado:Int
):Parcelable