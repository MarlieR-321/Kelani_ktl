package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.UsuarioDao
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Usuario
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.service.ClienteService
import uca.ni.edu.kelani.network.service.UsuarioService

class UsuarioRepository(private val usuarioService: UsuarioService = Api.usuarioService)
{
    suspend fun getUsers() : List<Usuario> {
        return usuarioService.getUsuario().map {
            it.toUsuario()

        }
    }

    suspend fun addUsuario(use: Usuario){
        usuarioService.saveUsuario(use.toUsuarioRequest())
    }
    suspend fun updateUsuario(use: Usuario){
        usuarioService.updateUsuario(use.toUsuarioRequest())
    }
    suspend fun deleteUsuario(use: Usuario){
        usuarioService.deleteUsuario(use.id_usuario)
    }

    /*suspend fun verifiactionUsuario(usur:String,pwd:String): Usuario{
        return  daoUs.getVerif(usur,pwd)
    }*/
}