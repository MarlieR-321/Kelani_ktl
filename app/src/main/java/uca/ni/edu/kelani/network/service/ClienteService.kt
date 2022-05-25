package uca.ni.edu.kelani.network.service

import retrofit2.http.*
import uca.ni.edu.kelani.network.requests.ClienteRequest
import uca.ni.edu.kelani.network.response.ClienteResponse

interface ClienteService {

    @GET("cliente/listar")
    suspend fun getCliente() : List<ClienteResponse>

    @POST("cliente/add")
    suspend fun saveCliente(@Body cliente: ClienteRequest)

    @PUT("cliente/edit/{id}")
    suspend fun updateCliente(@Body cliente: ClienteRequest)

    @DELETE("cliente/delete/{id}")
    suspend fun deleteCliente( @Path("id") id:Int)
}