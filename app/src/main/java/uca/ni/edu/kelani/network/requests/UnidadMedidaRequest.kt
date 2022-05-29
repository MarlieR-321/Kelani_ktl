package uca.ni.edu.kelani.network.requests

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName

class UnidadMedidaRequest(

@SerialName(value = "nombre_unidad")
@Expose
val nombre_unidad :String,

@SerialName(value = "abreviatura")
@Expose
val abreviatura :String,
@SerialName(value = "estado")
@Expose
val estado: Int
)