package uca.ni.edu.kelani.network.requests

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
class PostCategoriaRequest (
    @SerializedName(value = "nombre_categoria")
    val nombre :String,
     @SerializedName(value = "descripcion")
     val descripcion :String,
      @SerializedName(value = "estado")
     val estado: Int
)