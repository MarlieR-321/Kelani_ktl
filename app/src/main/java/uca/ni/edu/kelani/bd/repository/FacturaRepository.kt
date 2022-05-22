package uca.ni.edu.kelani.bd.repository

import uca.ni.edu.kelani.bd.dao.FacturaDao
import uca.ni.edu.kelani.bd.entidades.Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.service.FacturaService

class FacturaRepository(private val daoF:FacturaDao,
                        private val facturaService: FacturaService = Api.facturaService) {

    suspend fun getFactura() : List<vw_Factura> {
        return facturaService.getVwFactura().map {
            it.toVwFactura()
        }
    }

    suspend fun add(nac: Factura){
        daoF.insert(nac)
    }
    suspend fun update(nac: Factura){
        daoF.update(nac)
    }
    suspend fun delete(nac: Factura){
        daoF.delete(nac)
    }

}