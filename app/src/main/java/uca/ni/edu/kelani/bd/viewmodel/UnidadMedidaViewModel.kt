package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.UnidadMedida
import uca.ni.edu.kelani.bd.repository.ClienteRepository
import uca.ni.edu.kelani.bd.repository.UnidadMedidaRepository

class UnidadMedidaViewModel (application: Application): AndroidViewModel(application) {
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }
    //val listaUnidad: LiveData<List<UnidadMedida>>

    val listaUnidadMedida = MutableLiveData<List<UnidadMedida>>()

    private val repository: UnidadMedidaRepository = UnidadMedidaRepository()

    init {

        //listaUnidadMedida = repository.listAllData
        fetchUnidad()// Fetch Unidad from the Server

    }

    fun fetchUnidad() {
        viewModelScope.launch(Dispatchers.Default) {
            listaUnidadMedida.postValue(repository.getUnity())
        }
    }

    fun agregarMedida(um: UnidadMedida) {
        viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
            repository.addUnity(um)
        }
    }

    fun actualizarMedida(um: UnidadMedida) {
        viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
            repository.updateUnity(um)
        }
    }

    fun eliminarMedida(um: UnidadMedida) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.deleteUnity(um)
        }
    }
}
