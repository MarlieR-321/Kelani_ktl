package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.FacturaDetDao
import uca.ni.edu.kelani.bd.entidades.FacturaDet
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet

class FacturaDetRepository (private val daoF: FacturaDetDao, var id:Int = 0){
    val listAllData: LiveData<List<vw_FacturaDet>> = daoF.getById(id)

    suspend fun add(nac: FacturaDet){
        daoF.insert(nac)
    }

    suspend fun update(nac: FacturaDet){
        daoF.update(nac)
    }
    suspend fun delete(nac: FacturaDet){
        daoF.delete(nac)
    }

    suspend fun deleteByFact(id:Int){
        daoF.deleteByFact(id)
    }
}