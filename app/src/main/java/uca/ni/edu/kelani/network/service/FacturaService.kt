package uca.ni.edu.kelani.network.service

import retrofit2.http.*
import uca.ni.edu.kelani.bd.entidades.Factura
import uca.ni.edu.kelani.network.request.FacturaRequest
import uca.ni.edu.kelani.network.response.VwFacturaResponse

interface FacturaService {
    @GET("factura/listar")
    suspend fun getVwFactura():List<VwFacturaResponse>

    @POST("factura/add")
    suspend fun saveFactura(@Body factura: FacturaRequest):FacturaRequest

    @DELETE("factura/delete/{id}")
    suspend fun deleteFactura( @Path("id") id:Int)

}
