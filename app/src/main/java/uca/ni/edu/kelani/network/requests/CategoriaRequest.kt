package uca.ni.edu.kelani.network.requests

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName

class CategoriaRequest (

    @SerialName(value = "nombre")
    @Expose
    val nombre_categoria :String,

    @SerialName(value = "descripcion")
    @Expose
    val descripcion :String,


    @SerialName(value = "estado")
    @Expose
    val estado: Int


)