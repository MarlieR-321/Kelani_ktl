package uca.ni.edu.kelani.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="UnidadMedida")
data class UnidadMedida(
    @PrimaryKey(autoGenerate = true)
    val id_unidad:Int,
    @ColumnInfo(name="nombre_unidad")
    val nombre_unidad:String,
    @ColumnInfo(name="abreviatura")
    val abreviatura:String,
    @ColumnInfo(name="estado")
    val estado:Int
):Parcelable