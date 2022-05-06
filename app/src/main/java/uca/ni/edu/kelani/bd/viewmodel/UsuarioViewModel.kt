package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.Usuario
import uca.ni.edu.kelani.bd.repository.UsuarioRepository

class UsuarioViewModel(application: Application): AndroidViewModel(application) {
    val listaUsuario: LiveData<List<Usuario>>

    private val repository: UsuarioRepository

    init {
        val usuarioDao = bdKealni.getDataBase(application).usuarioDao()

        repository = UsuarioRepository(usuarioDao)
        listaUsuario = repository.listAllData

    }

    fun agregarUsuario(us: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUsuario(us)
        }
    }

    fun actualizarUsuario(us: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUsuario(us)
        }
    }

    fun eliminarUsuario(us: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUsuario(us)
        }
    }
}