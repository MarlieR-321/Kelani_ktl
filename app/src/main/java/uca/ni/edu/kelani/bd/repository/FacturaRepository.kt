package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.FacturaDao
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura

class FacturaRepository(private val daoF:FacturaDao) {
    val listAllData: LiveData<List<vw_Factura>> = daoF.getAllRealData()
    val listCliente: LiveData<List<Cliente>> = daoF.getClientes()

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