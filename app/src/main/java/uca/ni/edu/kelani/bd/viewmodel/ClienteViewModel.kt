package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.repository.ClienteRepository


class ClienteViewModel(application: Application): AndroidViewModel(application) {
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }
    //val listaCliente: LiveData<List<Cliente>>

    val listaCliente = MutableLiveData<List<Cliente>>()

    private val repository: ClienteRepository = ClienteRepository()

    init {
        //val clienteDao = bdKealni.getDataBase(application).clienteDao()

        //listaCliente = repository.listAllData
        fetchClientes()// Fetch cliente from the Server

    }

    fun fetchClientes() {
        viewModelScope.launch(Dispatchers.Default) {
            listaCliente.postValue(repository.getClients())
        }
    }

    fun agregarCliente(cl: Cliente) {
        viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
            repository.addCliente(cl)
        }
    }

    fun updateCliente(cl: Cliente) {
            viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
                repository.updateCliente(cl)
            }
        }

    fun eliminarCliente(cl: Cliente) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.deleteCliente(cl)
        }
    }
}
