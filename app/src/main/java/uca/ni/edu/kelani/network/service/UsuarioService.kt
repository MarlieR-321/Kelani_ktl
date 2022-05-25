package uca.ni.edu.kelani.network.service

import retrofit2.http.*
import uca.ni.edu.kelani.network.requests.ClienteRequest
import uca.ni.edu.kelani.network.requests.ClienteUpRequest
import uca.ni.edu.kelani.network.requests.UsuarioRequest
import uca.ni.edu.kelani.network.response.ClienteResponse
import uca.ni.edu.kelani.network.response.UsuarioResponse

interface UsuarioService {

    @GET("usuario/listar")
    suspend fun getUsuario() : List<UsuarioResponse>

    @POST("usuario/add")
    suspend fun saveUsuario(@Body usuario: UsuarioRequest)

    @PUT("usuario/edit")
    suspend fun updateUsuario(@Body usuario: UsuarioRequest)

    @DELETE("usuario/delete/{id}")
    suspend fun deleteUsuario( @Path("id") id:Int)
}