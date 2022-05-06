package uca.ni.edu.kelani.bd.entidades.views

import android.os.Parcelable
import androidx.room.DatabaseView
import kotlinx.android.parcel.Parcelize

@Parcelize
@DatabaseView("select p.id_producto, p.nombre_producto, p.descripcion, p.precio, p.costo, um.id_unidad, um.nombre_unidad as nombre_unidad, um.abreviatura, c.id_categoria, c.nombre_categoria, c.descripcion as descripcion_categoria from Producto p inner join UnidadMedida um on p.id_unidad=um.id_unidad inner join Categoria c on p.id_categoria=c.id_categoria;")
data class vw_Producto(
    val id_producto:Int,
    val nombre_producto:String,
    val descripcion:String,
    val precio:Double,
    val costo:Double,
    val id_unidad:Int,
    val nombre_unidad:String,
    val abreviatura:String,
    val id_categoria:Int,
    val nombre_categoria:String,
    val descripcion_categoria:String
): Parcelable