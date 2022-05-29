package uca.ni.edu.kelani.bd.viewmodel



import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uca.ni.edu.kelani.bd.dao.bdKealni
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.bd.repository.CategoriaRepository


class CategoriaViewModel (application: Application): AndroidViewModel(application)
    {
        val listaCategoria = MutableLiveData<List<Categoria>>()

        private val repository: CategoriaRepository = CategoriaRepository()

        init {
            //val categoriaDao = bdKealni.getDataBase(application).categoriatDao()

            //repository = CategoriaRepository(categoriaDao)
            fetchCategories() // Fetch categories from the Server

        }

        fun fetchCategories() {
            viewModelScope.launch(Dispatchers.Default) {
                listaCategoria.postValue(repository.getCategories())
            }
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
