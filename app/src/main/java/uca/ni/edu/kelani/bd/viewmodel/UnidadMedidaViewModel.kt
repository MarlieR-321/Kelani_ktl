package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.UnidadMedida
import uca.ni.edu.kelani.bd.repository.UnidadMedidaRepository

class UnidadMedidaViewModel (application: Application): AndroidViewModel(application) {
    val listaUnidadMedida: LiveData<List<UnidadMedida>>

    private val repository: UnidadMedidaRepository

    init {
        val unidadMedidaDao = bdKealni.getDataBase(application).unidadtDao()

        repository = UnidadMedidaRepository(unidadMedidaDao)
        listaUnidadMedida = repository.listAllData

    }

    fun agregarMedida(um: UnidadMedida) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMeasure(um)
        }
    }

    fun actualizarMedida(um: UnidadMedida) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateMeasure(um)
        }
    }

    fun eliminarMedida(um: UnidadMedida) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteMeasure(um)
        }
    }
}