package uca.ni.edu.kelani.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Usuario

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  isert(usuario: Usuario)

    @Query("SELECT * FROM Usuario")
    suspend fun getAll(): List<Usuario>

    @Query("SELECT * FROM Usuario")
    fun getAllRealData(): LiveData<List<Usuario>>

    @Query("SELECT * FROM Usuario WHERE id_usuario = :id")
    suspend fun getById(id : Int) : Usuario

    @Update
    suspend fun update(usuario: Usuario)

    @Delete
    suspend fun delete(usuario: Usuario)
}