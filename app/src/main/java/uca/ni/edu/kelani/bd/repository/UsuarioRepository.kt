package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.UsuarioDao
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Usuario

class UsuarioRepository(private val daoUs: UsuarioDao) {
    val listAllData: LiveData<List<Usuario>> = daoUs.getAllRealData()

    suspend fun addUsuario(use: Usuario){
        daoUs.isert(use)
    }
    suspend fun updateUsuario(use: Usuario){
        daoUs.update(use)
    }
    suspend fun deleteUsuario(use: Usuario){
        daoUs.update(use)
    }

    suspend fun verifiactionUsuario(usur:String,pwd:String): Usuario{
        return  daoUs.getVerif(usur,pwd)

    }
}