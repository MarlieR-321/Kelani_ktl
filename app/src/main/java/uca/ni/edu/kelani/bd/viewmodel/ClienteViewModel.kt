package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas50.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.repository.ClienteRepository


class ClienteViewModel(application: Application): AndroidViewModel(application) {
    val listaCliente: LiveData<List<Cliente>>

    private val repository: ClienteRepository

    init {
        val clienteDao = bdKealni.getDataBase(application).clienteDao()

        repository = ClienteRepository(clienteDao)
        listaCliente = repository.listAllData

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