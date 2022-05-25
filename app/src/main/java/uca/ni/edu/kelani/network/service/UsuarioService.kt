package uca.ni.edu.kelani.network.service

import retrofit2.http.*
import uca.ni.edu.kelani.network.requests.ClienteRequest
import uca.ni.edu.kelani.network.response.ClienteResponse

interface UsuarioService {

    @GET("usuario/listar")
    suspend fun getCliente() : List<ClienteResponse>

    @POST("usuario/add")
    suspend fun saveCliente(@Body cliente: ClienteRequest)

    @DELETE("usuario/delete/{id}")
    suspend fun deleteCliente( @Path("id") id:Int)
}