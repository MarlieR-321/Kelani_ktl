package uca.ni.edu.kelani.network.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import uca.ni.edu.kelani.network.requests.FacturaDetRequest
import uca.ni.edu.kelani.network.response.VwFacturaDetResponse

interface FacturaDetService
{
    @GET("fdetalle/listar")
    suspend fun getDetalles(): List<VwFacturaDetResponse>

    @POST("fdetalle/add")
    suspend fun addDetalle(fdetalle: FacturaDetRequest):FacturaDetRequest

    @DELETE("fdetalle/delete/{id}")
    suspend fun deleteDetalle(@Path("id") id:Int)
}