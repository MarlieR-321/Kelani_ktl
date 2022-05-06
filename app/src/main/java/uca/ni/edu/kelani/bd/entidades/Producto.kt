package uca.ni.edu.kelani.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="Producto",
        foreignKeys = [
            ForeignKey(entity = Categoria::class, parentColumns = ["id_categoria"], childColumns = ["id_categoria"]),
            ForeignKey(entity = UnidadMedida::class, parentColumns = ["id_unidad"], childColumns = ["id_unidad"])
        ])
data class Producto (
    @PrimaryKey(autoGenerate = true)
    val id_producto:Int,
    @ColumnInfo(name="id_unidad")
    val id_unidad:Int,
    @ColumnInfo(name="abreviacion")
    val abreviacion:String,
    @ColumnInfo(name="id_categoria")
    val id_categoria:Int,
    @ColumnInfo(name="descripcion_categoria")
    val descripcion_categoria:String,
    @ColumnInfo(name="nombre_producto")
    val nombre_producto:String,
    @ColumnInfo(name="descripcion")
    val descripcion:String,
    @ColumnInfo(name="precio")
    val precio:Double,
    @ColumnInfo(name="costo")
    val costo:Double,
    @ColumnInfo(name="estado")
    val estado:Int
        ):Parcelable