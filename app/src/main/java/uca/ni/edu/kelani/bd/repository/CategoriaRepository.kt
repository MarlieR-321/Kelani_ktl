package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.CategoriaDao

import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.service.CategoriaService


class CategoriaRepository(private val daoCat: CategoriaDao,
                          private val categoriaService: CategoriaService = Api.categoriaService)
{

    suspend fun getCategories() : List<Categoria> {
        return categoriaService.getCategorias().map {
            it.toCategoria()
        }
    }
    suspend fun addCategory(cat: Categoria){
        daoCat.insert(cat)
    }

    suspend fun updateCategory(cat: Categoria){
        daoCat.update(cat)
    }
    suspend fun deleteCategory(cat: Categoria){
        daoCat.update(cat)
    }
}