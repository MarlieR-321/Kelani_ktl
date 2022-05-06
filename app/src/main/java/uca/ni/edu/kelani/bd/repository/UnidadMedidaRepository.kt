package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.UnidadMedidaDao
import uca.ni.edu.kelani.bd.entidades.UnidadMedida

class UnidadMedidaRepository (private val daoUM: UnidadMedidaDao) {
    val listAllData: LiveData<List<UnidadMedida>> = daoUM.getAllRealData()

    suspend fun addMeasure(umd: UnidadMedida){
        daoUM.insert(umd)
    }

    suspend fun updateMeasure(umd: UnidadMedida){
        daoUM.update(umd)
    }
    suspend fun deleteMeasure(umd: UnidadMedida){
        daoUM.delete(umd)
    }
}