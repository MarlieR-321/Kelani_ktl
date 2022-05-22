package uca.ni.edu.kelani.network.service

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import uca.ni.edu.kelani.network.response.CategoriaResponse

interface CategoriaService {

    @GET("categoria/listar")
    suspend fun getCategorias() : List<CategoriaResponse>

}