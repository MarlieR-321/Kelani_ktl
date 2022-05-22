package uca.ni.edu.kelani.network.service

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import uca.ni.edu.kelani.network.response.FacturaResponse
import uca.ni.edu.kelani.network.response.VwFacturaResponse

interface FacturaService {
    @GET("factura/listar")
    suspend fun getVwFactura():List<VwFacturaResponse>

    @POST("factura/add")
    suspend fun saveFactura(@Body factura: FacturaResponse)

}
