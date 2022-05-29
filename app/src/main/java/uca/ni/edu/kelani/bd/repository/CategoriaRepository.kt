package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import retrofit2.http.*
import uca.ni.edu.kelani.bd.dao.CategoriaDao

import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.network.Api
import uca.ni.edu.kelani.network.service.CategoriaService


class CategoriaRepository(private val  categoriaService: CategoriaService = Api.categoriaService)
{

    suspend fun getCategories() : List<Categoria> {
        return categoriaService.getCategorias().map {
            it.toCategoria()
        }
    }
    suspend fun addCategory(cat: Categoria){
        categoriaService.saveCategory( cat.toCategoryRequest())
    }

    suspend fun updateCategory(cat: Categoria){
        categoriaService.updateCategory( cat.toCategoryUpRequest())
    }
    suspend fun deleteCategory(cat: Categoria){
        categoriaService.deleteCategory(cat.id_categoria)
    }
}