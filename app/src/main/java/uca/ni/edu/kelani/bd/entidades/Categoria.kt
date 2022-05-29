package uca.ni.edu.kelani.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import uca.ni.edu.kelani.network.requests.CategoriaRequest
import uca.ni.edu.kelani.network.requests.CategoriaUpRequest



@Parcelize
@Entity(tableName="Categoria")
data class Categoria(
    @PrimaryKey(autoGenerate = true)
    var id_categoria : Int,
    @ColumnInfo(name="nombre_categoria")
    var nombre_categoria:String,
    @ColumnInfo(name="descripcion")
    var descripcion:String,
    @ColumnInfo(name="estado")
    var estado: Int
):Parcelable{
    fun toCategoryRequest(): CategoriaRequest
            = CategoriaRequest(nombre_categoria, descripcion, estado)

    fun toCategoryUpRequest(): CategoriaUpRequest
            = CategoriaUpRequest(id_categoria, nombre_categoria, descripcion, estado)
}