package uca.ni.edu.kelani.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.bd.entidades.Cliente

@Dao
interface ClienteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  isert(cliente: Cliente)

    @Query("SELECT * FROM Cliente where estado<>3")
    suspend fun getAll(): List<Cliente>

    @Query("SELECT * FROM Cliente where estado<>3")
    fun getAllRealData(): LiveData<List<Cliente>>

    @Query("SELECT * FROM Cliente WHERE id_cliente = :id")
    suspend fun getById(id : Int) : Cliente

    @Update
    suspend fun update(cliente: Cliente)

//Inutilizable el delete por cambiar el estado a 3
    @Delete
    suspend fun delete(cliente: Cliente)
}