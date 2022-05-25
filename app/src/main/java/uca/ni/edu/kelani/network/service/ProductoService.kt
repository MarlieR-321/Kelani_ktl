package uca.ni.edu.kelani.network.service

import retrofit2.http.*
import uca.ni.edu.kelani.network.requests.ProductoRequest
import uca.ni.edu.kelani.network.response.Vw_ProductoResponse

interface ProductoService {
    @GET("producto/listar")
    suspend fun getVwProducto():List<Vw_ProductoResponse>

    @POST("producto/add")
    suspend fun saveProducto(@Body producto: ProductoRequest): ProductoRequest

    @DELETE("producto/delete/{id}")
    suspend fun deleteProducto( @Path("id")id:Int)
}