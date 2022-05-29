package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.UnidadMedidaDao
import uca.ni.edu.kelani.bd.entidades.UnidadMedida
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.service.UnidadMedidaService

class UnidadMedidaRepository (private val unidadMedidaService : UnidadMedidaService = Api.unidadMedidaService)
{
    suspend fun getUnity() : List<UnidadMedida> {
        return unidadMedidaService.getUnity().map {
            it.toUnity()
        }
    }

    suspend fun addUnity(um: UnidadMedida){
            unidadMedidaService.saveUnity(um.toUnityRequest())
    }

    suspend fun updateUnity(um: UnidadMedida){
        unidadMedidaService.updateUnity(um.toUnityUpRequest())
    }

    suspend fun deleteUnity(um: UnidadMedida) {
        unidadMedidaService.deleteUnity(um.id_unidad)
    }
}