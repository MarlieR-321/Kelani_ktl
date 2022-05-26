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
import uca.ni.edu.kelani.bd.entidades.Usuario
import uca.ni.edu.kelani.bd.repository.UsuarioRepository

class UsuarioViewModel(application: Application): AndroidViewModel(application) {
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    //val listaUsuario: LiveData<List<Usuario>>

    val listaUsuario = MutableLiveData<List<Usuario>>()

    private val repository: UsuarioRepository = UsuarioRepository()

    init {
        /*val usuarioDao = bdKealni.getDataBase(application).usuarioDao()

        repository = UsuarioRepository(usuarioDao)
        listaUsuario = repository.listAllData*/
        fetchUsuarios()// Fetch cliente from the Server
    }

    fun fetchUsuarios() {
        viewModelScope.launch(Dispatchers.Default) {
            listaUsuario.postValue(repository.getUsers())
        }
    }

    fun agregarUsuario(us: Usuario) {
        viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
            repository.addUsuario(us)
        }
    }

    fun actualizarUsuario(us: Usuario) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.updateUsuario(us)
        }
    }

    fun eliminarUsuario(us: Usuario) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.deleteUsuario(us)
        }
    }
}