package uca.ni.edu.kelani.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.Factura
import uca.ni.edu.kelani.bd.entidades.Producto
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_Producto
import uca.ni.edu.kelani.bd.repository.FacturaRepository
import uca.ni.edu.kelani.bd.repository.ProductoRepository

class ProductoViewModel (application: Application): AndroidViewModel(application) {
    val listaProducto: LiveData<List<vw_Producto>>
    private val repository: ProductoRepository

    init {
        val productoDao = bdKealni.getDataBase(application).productoDao()

        repository = ProductoRepository(productoDao)
        listaProducto = repository.listAllData
    }

    fun agregarProducto(producto: Producto){
        viewModelScope.launch(Dispatchers.IO) {
            repository.add(producto)
        }

    }

    fun actualizarProducto(producto: Producto) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(producto)
        }
    }

    fun eliminarProducto(producto: Producto) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(producto)
        }
    }
}