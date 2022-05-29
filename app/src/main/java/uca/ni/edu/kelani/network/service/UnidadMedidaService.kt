package uca.ni.edu.kelani.network.service

import retrofit2.http.*
import uca.ni.edu.kelani.bd.entidades.UnidadMedida
import uca.ni.edu.kelani.network.requests.ClienteRequest
import uca.ni.edu.kelani.network.requests.ClienteUpRequest
import uca.ni.edu.kelani.network.requests.UnidadMedidaRequest
import uca.ni.edu.kelani.network.requests.UnidadMedidaUpRequest
import uca.ni.edu.kelani.network.response.ClienteResponse
import uca.ni.edu.kelani.network.response.UnidadMedidaResponse

interface UnidadMedidaService {

    @GET("unidadMedida/listar")
    suspend fun getUnity() : List<UnidadMedidaResponse>

    @POST("unidadMedida/add")
    suspend fun saveUnity(@Body  unidadMedida: UnidadMedidaRequest)

    @POST("unidadMedida/add")
    suspend fun updateUnity(@Body unidadMedida:  UnidadMedidaUpRequest)

    @DELETE("unidadMedida/delete/{id}")
    suspend fun deleteUnity( @Path("id") id:Int)
}