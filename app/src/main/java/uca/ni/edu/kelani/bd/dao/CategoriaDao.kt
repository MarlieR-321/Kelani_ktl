package uca.ni.edu.kelani.bd.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import uca.ni.edu.kelani.bd.entidades.Categoria

@Dao
interface CategoriaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(categoria: Categoria)

    @Query("SELECT * FROM Categoria where estado<>3")
    suspend fun getAll(): List<Categoria>

    @Query("SELECT * FROM Categoria where estado<>3")
    fun getAllRealData(): LiveData<List<Categoria>>

    @Query("SELECT * FROM Categoria WHERE id_categoria = :id")
    suspend fun getById(id : Int) : Categoria

    @Update
    suspend fun update(categoria: Categoria)

    @Delete
    suspend fun delete(categoria: Categoria)
}







