package uca.ni.edu.kelani.network.service

import retrofit2.http.GET
import uca.ni.edu.kelani.network.response.VwFacturaResponse

interface FacturaService {
    @GET("factura/listar")
    suspend fun getVwFactura():List<VwFacturaResponse>

}