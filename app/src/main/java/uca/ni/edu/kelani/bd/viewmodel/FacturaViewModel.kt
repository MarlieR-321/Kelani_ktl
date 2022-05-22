package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.bd.repository.FacturaRepository
import uca.ni.edu.kelani.network.response.VwFacturaResponse

class FacturaViewModel(application: Application):AndroidViewModel(application)
    {

        val listaFactura = MutableLiveData<List<vw_Factura>>()

        private val repository:FacturaRepository = FacturaRepository()

        init {
            //val facturaDao = bdKealni.getDataBase(application).facturaDao()

            fetchFactura()
        }

        fun fetchFactura() {
            viewModelScope.launch(Dispatchers.Default) {
                listaFactura.postValue(repository.getFactura())
            }
        }

        fun agregarFactura(f: Factura){
            viewModelScope.launch(Dispatchers.IO) {
                repository.add(f)
            }

        }

        fun eliminarFactura(f: Factura) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.delete(f)
            }
        }
    }