package uca.ni.edu.kelani.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Factura
import uca.ni.edu.kelani.bd.entidades.Producto
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura

@Dao
interface FacturaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clasificacion: Factura)

    @Query("SELECT * FROM vw_Factura order by id_factura desc")
    fun getAllRealData(): LiveData<List<vw_Factura>>

    @Query("SELECT * FROM Factura WHERE id_factura = :id")
    suspend fun getById(id : Int) : Factura

    @Update
    suspend fun update(clasificacion: Factura)

    @Query("Update Factura set total=:total where id_factura=:id")
    suspend fun updateTotal(total:Double,id:Int)

    @Delete
    suspend fun delete(clasificacion: Factura)
}