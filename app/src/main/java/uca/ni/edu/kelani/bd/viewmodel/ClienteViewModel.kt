package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.repository.CategoriaRepository
import uca.ni.edu.kelani.bd.repository.ClienteRepository


class ClienteViewModel(application: Application): AndroidViewModel(application) {
    //val listaCliente: LiveData<List<Cliente>>

        val listaCliente = MutableLiveData<List<Cliente>>()

        private val repository:ClienteRepository

    init {
        val clienteDao = bdKealni.getDataBase(application).clienteDao()

        repository = ClienteRepository(clienteDao)
        //listaCliente = repository.listAllData
        fetchClientes()// Fetch cliente from the Server

    }

    private fun fetchClientes() {
        viewModelScope.launch(Dispatchers.Default) {
            listaCliente.postValue(repository.getClients())
        }
    }

    fun agregarCliente(cl: Cliente) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCliente(cl)
        }
    }

    fun actualizarCliente(cl: Cliente) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCliente(cl)
        }
    }

    fun eliminarCliente(cl: Cliente) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCliente(cl)
        }
    }
}