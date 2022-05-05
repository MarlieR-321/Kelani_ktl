package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas50.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.bd.repository.FacturaRepository

class FacturaViewModel(application: Application):AndroidViewModel(application) {
    val listaFactura: LiveData<List<vw_Factura>>
    private val repository:FacturaRepository

    init {
        val facturaDao = bdKealni.getDataBase(application).facturaDao()

        repository = FacturaRepository(facturaDao)
        listaFactura = repository.listAllData

    }

    fun agregarFactura(f: Factura) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.add(f)
        }
    }

    fun actualizarFactura(f: Factura) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(f)
        }
    }

    fun eliminarFactura(f: Factura) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(f)
        }
    }
}