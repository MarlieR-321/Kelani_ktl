package uca.ni.edu.kelani.bd.repository

import kotlinx.coroutines.CoroutineExceptionHandler
import uca.ni.edu.kelani.bd.entidades.Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.request.FacturaRequest
import uca.ni.edu.kelani.network.service.FacturaService

class FacturaRepository(private val facturaService: FacturaService = Api.facturaService) {

    suspend fun getFactura() : List<vw_Factura> {
        return facturaService.getVwFactura().map {
            it.toVwFactura()
        }
    }

    suspend fun add(fac: Factura){
        val request = FacturaRequest(fac.estado,fac.fecha,fac.total,fac.id_cliente,fac.telefono,fac.direccion)
        facturaService.saveFactura(request)
        //daoF.insert(nac)
    }

    suspend fun delete(nac: Factura){
    facturaService.deleteFactura(nac.id_factura)
    //daoF.delete(nac)
    }

}