package uca.ni.edu.kelani.network.service

import retrofit2.http.*
import uca.ni.edu.kelani.network.requests.PostClienteRequest
import uca.ni.edu.kelani.network.response.ClienteResponse

interface ClienteService {

    @GET("cliente/listar")
    suspend fun getCliente() : List<ClienteResponse>

    @POST("cliente/add")
    suspend fun addCliente(@Body clienteRequest: PostClienteRequest)

    @DELETE("cliente/delete/{id}")
    suspend fun deleteCliente( @Path("id") id:Int)
}