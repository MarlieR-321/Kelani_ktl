package uca.ni.edu.kelani.bd.repository

import androidx.lifecycle.LiveData
import uca.ni.edu.kelani.bd.dao.CategoriaDao

import uca.ni.edu.kelani.bd.entidades.Categoria



class CategoriaRepository(private val daoCat: CategoriaDao) {
    val listAllData: LiveData<List<Categoria>> = daoCat.getAllRealData()

    suspend fun addCategory(cat: Categoria){
        daoCat.insert(cat)
    }

    suspend fun updateCategory(cat: Categoria){
        daoCat.update(cat)
    }
    suspend fun deleteCategory(cat: Categoria){
        daoCat.delete(cat)
    }
}