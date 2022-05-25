package uca.ni.edu.kelani.bd.repository


import uca.ni.edu.kelani.bd.dao.ClienteDao
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.service.ClienteService


class ClienteRepository(private val clienteService: ClienteService = Api.clienteService)
{
    suspend fun getClients() : List<Cliente> {
        return clienteService.getCliente().map {
            it.toCliente()
        }
    }

    suspend fun addCliente(cli: Cliente){
        clienteService.saveCliente(cli.toClienteRequest())
    }

    suspend fun updateCliente(cli: Cliente){
        clienteService.updateCliente(cli.toClienteUpRequest())
    }

    suspend fun deleteCliente(cli: Cliente) {
        clienteService.deleteCliente(cli.id_cliente)
    }
}