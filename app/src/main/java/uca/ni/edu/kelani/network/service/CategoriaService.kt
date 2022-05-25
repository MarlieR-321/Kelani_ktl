package uca.ni.edu.kelani.network.service

import retrofit2.http.*
import uca.ni.edu.kelani.network.requests.PostCategoriaRequest
import uca.ni.edu.kelani.network.response.CategoriaResponse

interface CategoriaService {

    @GET("categoria/listar")
    suspend fun getCategorias() : List<CategoriaResponse>

    @POST("categoria/add")
    suspend fun addCategory(@Body categoriaRequest: PostCategoriaRequest)

    @GET("categoria/delete/{id}")
    suspend fun deleteCategory( @Path("id") id:Int)
}
