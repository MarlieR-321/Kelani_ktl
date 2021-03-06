package uca.ni.edu.kelani.network.service

import retrofit2.http.*
import uca.ni.edu.kelani.network.requests.CategoriaRequest
import uca.ni.edu.kelani.network.requests.CategoriaUpRequest
import uca.ni.edu.kelani.network.requests.ClienteUpRequest
import uca.ni.edu.kelani.network.response.CategoriaResponse

interface CategoriaService {

    @GET("categoria/listar")
    suspend fun getCategorias() : List<CategoriaResponse>

    @POST("categoria/add")
    suspend fun saveCategory(@Body categoria: CategoriaRequest)


    @POST("categoria/add")
    suspend fun updateCategory(@Body categoria: CategoriaUpRequest)

    @DELETE("categoria/delete/{id}")
    suspend fun deleteCategory( @Path("id") id:Int)
}
