package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.FacturaDetDao
import uca.ni.edu.kelani.bd.entidades.FacturaDet
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.service.FacturaDetService
import uca.ni.edu.kelani.network.service.FacturaService

class FacturaDetRepository (private val facturaDetService: FacturaDetService = Api.facturaDetService){
    //val listAllData: LiveData<List<vw_FacturaDet>> = daoF.getById(id)

     suspend fun getFacturaDet() : List<vw_FacturaDet> {
        return facturaDetService.getDetalles().map {
            it.toVwFacturaDet()
        }
    }

    suspend fun add(nac: FacturaDet){
        //daoF.insert(nac)
        facturaDetService.addDetalle(nac.toRequest())
    }

    suspend fun delete(nac: FacturaDet){
        facturaDetService.deleteDetalle(nac.id_factura_det)
        //daoF.delete(nac)
    }
}