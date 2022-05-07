package uca.ni.edu.kelani.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.FacturaDet
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet

@Dao
interface FacturaDetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clasificacion: FacturaDet)

    @Query("SELECT * FROM vw_FacturaDet")
    fun getAllRealData(): LiveData<List<vw_FacturaDet>>

    @Query("SELECT * FROM vw_FacturaDet WHERE id_factura = :id")
    fun getById(id : Int) : LiveData<List<vw_FacturaDet>>

    @Query("Delete FROM FacturaDet WHERE id_factura = :id")
    suspend fun deleteByFact(id : Int)

    @Update
    suspend fun update(clasificacion: FacturaDet)

    @Delete
    suspend fun delete(clasificacion: FacturaDet)
}