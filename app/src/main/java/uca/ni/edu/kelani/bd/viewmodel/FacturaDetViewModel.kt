package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.dao.FacturaDetDao
import uca.ni.edu.kelani.bd.entidades.FacturaDet
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet
import uca.ni.edu.kelani.bd.repository.FacturaDetRepository

class FacturaDetViewModel(application: Application): AndroidViewModel(application) {

    private val repository: FacturaDetRepository
    val facturaDao: FacturaDetDao = bdKealni.getDataBase(application).facturaDetDao()

    init {

        repository = FacturaDetRepository(facturaDao)

    }
    fun listarById(id:Int):LiveData<List<vw_FacturaDet>>{
        val repositoryList = FacturaDetRepository(facturaDao, id)
        return repositoryList.listAllData
    }

    fun agregarFacturaDet(f: FacturaDet) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.add(f)
        }
    }

    fun actualizarFacturaDet(f: FacturaDet) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(f)
        }
    }

    fun eliminarFacturaDet(f: FacturaDet) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(f)
        }
    }
}