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

    @Query("SELECT * FROM vw_Factura")
    fun getAllRealData(): LiveData<List<vw_Factura>>

    @Query("SELECT * FROM Factura WHERE id_factura = :id")
    suspend fun getById(id : Int) : Factura

    @Update
    suspend fun update(clasificacion: Factura)

    @Delete
    suspend fun delete(clasificacion: Factura)

    @Query("SELECT id_factura FROM Factura Order by id_factura desc Limit 1")
    suspend fun getIdLast():Int

    //Editar una vez se tengan los daos correspondientes
    @Query("SELECT * FROM Cliente where estado<>3")
    suspend fun getClientes():List<Cliente>

    @Query("SELECT * FROM Cliente where id_cliente = :id")
    suspend fun getClienteById(id:Int):Cliente

    @Query("SELECT * FROM Producto where estado<>3")
    suspend fun getProducto():List<Producto>

    @Query("SELECT * FROM Producto where id_producto = :id")
    suspend fun getProductoById(id:Int): Producto
}