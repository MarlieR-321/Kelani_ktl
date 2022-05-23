package uca.ni.edu.kelani.network.service

import retrofit2.http.*
import uca.ni.edu.kelani.network.requests.FacturaDetRequest
import uca.ni.edu.kelani.network.response.VwFacturaDetResponse

interface FacturaDetService
{
    @GET("fdetalle/listar")
    suspend fun getDetalles(): List<VwFacturaDetResponse>

    @POST("fdetalle/add")
    suspend fun addDetalle(@Body fdetalle: FacturaDetRequest):FacturaDetRequest

    @DELETE("fdetalle/delete/{id}")
    suspend fun deleteDetalle(@Path("id") id:Int)
}