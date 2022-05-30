package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.ProductoDao
import uca.ni.edu.kelani.bd.entidades.Producto
import uca.ni.edu.kelani.bd.entidades.views.vw_Producto
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.service.ProductoService

class ProductoRepository(private val productoService: ProductoService = Api.productoService) {

    //val listAllData: LiveData<List<vw_Producto>> = daoP.getAllRealData()

    suspend fun getProducto() : List<vw_Producto>{
        return productoService.getVwProducto().map {
            it.toVwProducto()
        }
    }

    suspend fun add(producto: Producto){
        productoService.saveProducto(producto.toProductoRequest())
        //daoP.insert(producto)
    }

    suspend fun update(producto: Producto){
        productoService.updateProducto(producto.toProductoUpRequest())
        //daoP.update(producto)
    }

    suspend fun delete(producto: Producto){
        productoService.deleteProducto(producto.id_producto)
        //daoP.delete(producto)
    }

}