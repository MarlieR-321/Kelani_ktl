package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.ProductoDao
import uca.ni.edu.kelani.bd.entidades.Producto
import uca.ni.edu.kelani.bd.entidades.views.vw_Producto

class ProductoRepository(private val daoP: ProductoDao) {
    val listAllData: LiveData<List<vw_Producto>> = daoP.getAllRealData()

    suspend fun add(producto: Producto){
        daoP.insert(producto)
    }
    suspend fun update(producto: Producto){
        daoP.update(producto)
    }
    suspend fun delete(producto: Producto){
        daoP.delete(producto)
    }

}