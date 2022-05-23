package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.ClienteDao
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Factura
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.requests.PostClienteRequest
import uca.ni.edu.kelani.network.response.ClienteResponse
import uca.ni.edu.kelani.network.response.toModel
import uca.ni.edu.kelani.network.service.ClienteService


class ClienteRepository(private val daoCl: ClienteDao,
    //val listAllData: LiveData<List<Cliente>> = daoCl.getAllRealData()
                        //var id:Int = 0,
                        private val clienteService: ClienteService = Api.clienteService)
{
    val listAllData: LiveData<List<Cliente>> = daoCl.getAllRealData()

    suspend fun getClients() : List<Cliente> {
        return clienteService.getCliente().map(ClienteResponse::toModel)
    }

    suspend fun addCliente(cli: Cliente){
        val request = PostClienteRequest(cli.nombre, cli.apellido, cli.telefono, cli.cedula, cli.direccion, cli.estado)
        //clienteService.saveCliente(cli.toClienteResponse())
        clienteService.addCliente(request)
    }

    suspend fun updateCliente(cli: Cliente){
        daoCl.update(cli)
    }
    suspend fun deleteCliente(cli: Cliente) {
        daoCl.update(cli)
    }

    /*suspend fun delete(cli: Cliente){
        clienteService.deleteCliente(cli.id_cliente)
    }*/



    /*suspend fun addCliente(cli: Cliente){
        daoCl.isert(cli)
    }
    suspend fun updateCliente(cli: Cliente){
        daoCl.update(cli)
    }
    suspend fun deleteCliente(cli: Cliente){
        daoCl.update(cli)
    }*/
}