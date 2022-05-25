package uca.ni.edu.kelani.bd.repository


import uca.ni.edu.kelani.bd.dao.ClienteDao
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.service.ClienteService


class ClienteRepository(private val clienteService: ClienteService = Api.clienteService)
{
    //val listAllData: LiveData<List<Cliente>> = daoCl.getAllRealData()

    suspend fun getClients() : List<Cliente> {
        return clienteService.getCliente().map {
            it.toCliente()
        }
    }

    suspend fun addCliente(cli: Cliente){
        //val request = PostClienteRequest(cli.nombre, cli.apellido, cli.telefono, cli.cedula, cli.direccion, cli.estado)
        //clienteService.saveCliente(cli.toClienteResponse())
        clienteService.saveCliente(cli.toClienteRequest())
    }

    suspend fun updateCliente(cli: Cliente){
        clienteService.updateCliente(cli.toClienteRequest())
    }

    suspend fun deleteCliente(cli: Cliente) {
        clienteService.deleteCliente(cli.id_cliente)
    }


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