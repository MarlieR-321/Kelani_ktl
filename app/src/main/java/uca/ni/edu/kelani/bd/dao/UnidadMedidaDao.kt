package uca.ni.edu.kelani.bd.dao

import androidx.room.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import uca.ni.edu.kelani.bd.entidades.UnidadMedida

@Dao
interface UnidadMedidaDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(unidadMedida: UnidadMedida)

    @Query("SELECT * FROM UnidadMedida")
    suspend fun getAll(): List<UnidadMedida>

    @Query("SELECT * FROM UnidadMedida")
    fun getAllRealData(): LiveData<List<UnidadMedida>>

    @Query("SELECT * FROM UnidadMedida WHERE id_unidad = :id")
    suspend fun getById(id : Int) : UnidadMedida

    @Update
    suspend fun update(unidadMedida: UnidadMedida)

    @Delete
    suspend fun delete(unidadMedida: UnidadMedida)
}

