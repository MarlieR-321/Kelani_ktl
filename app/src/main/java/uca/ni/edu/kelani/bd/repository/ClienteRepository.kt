package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.ClienteDao
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Factura


class ClienteRepository(private val daoCl: ClienteDao) {
    val listAllData: LiveData<List<Cliente>> = daoCl.getAllRealData()

    suspend fun addCliente(cli: Cliente){
        daoCl.isert(cli)
    }
    suspend fun updateCliente(cli: Cliente){
        daoCl.update(cli)
    }
    suspend fun deleteCliente(cli: Cliente){
        daoCl.update(cli)
    }
}