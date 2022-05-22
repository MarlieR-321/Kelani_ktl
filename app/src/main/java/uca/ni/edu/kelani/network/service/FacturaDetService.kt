package uca.ni.edu.kelani.network.service

import retrofit2.http.GET
import uca.ni.edu.kelani.network.response.VwFacturaDetResponse

interface FacturaDetService
{
    @GET("fdetalle/listar")
    fun getDetalles(): List<VwFacturaDetResponse>
}