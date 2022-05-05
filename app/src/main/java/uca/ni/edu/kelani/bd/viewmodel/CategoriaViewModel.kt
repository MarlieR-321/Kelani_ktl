package uca.ni.edu.kelani.bd.viewmodel



import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas50.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.bd.repository.CategoriaRepository


class CategoriaViewModel (application: Application): AndroidViewModel(application)
    {
        val listaCategoria: LiveData<List<Categoria>>

        private val repository: CategoriaRepository

        init {
            val categoriaDao = bdKealni.getDataBase(application).categoriatDao()

            repository = CategoriaRepository(categoriaDao)
            listaCategoria = repository.listAllData

        }

        fun agregarCategoria(cat: Categoria) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.addCategory(cat)
            }
        }

        fun actualizarCategoria(cat: Categoria) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.updateCategory(cat)
            }
        }

        fun eliminarCategoria(cat: Categoria) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.deleteCategory(cat)
            }
        }

    }
