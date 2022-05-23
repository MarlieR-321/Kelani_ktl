package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.dao.FacturaDetDao
import uca.ni.edu.kelani.bd.entidades.FacturaDet
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet
import uca.ni.edu.kelani.bd.repository.FacturaDetRepository

class FacturaDetViewModel(application: Application): AndroidViewModel(application) {

    private val repository: FacturaDetRepository = FacturaDetRepository()
    val listaFactura = MutableLiveData<List<vw_FacturaDet>>()

    init {
        fetchFactura()
    }



    fun fetchFactura() {
        viewModelScope.launch(Dispatchers.Default) {
            listaFactura.postValue(repository.getFacturaDet())
        }
    }

    fun agregarFacturaDet(f: FacturaDet) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.add(f)
        }
    }


    fun eliminarFacturaDet(f: FacturaDet) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(f)
        }
    }
}