package uca.ni.edu.kelani.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Producto
import uca.ni.edu.kelani.bd.entidades.UnidadMedida
import uca.ni.edu.kelani.bd.entidades.views.vw_Producto

@Dao
interface ProductoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(producto: Producto)

    @Query("SELECT * FROM vw_Producto order by id_producto desc")
    fun getAllRealData(): LiveData<List<vw_Producto>>

    @Query("SELECT * FROM Producto where estado<>3")
    suspend fun getAll(): List<Producto>

    @Query("SELECT * FROM Producto WHERE id_producto = :id")
    suspend fun getById(id : Int) : Producto

    @Update
    suspend fun update(producto: Producto)

    @Delete
    suspend fun delete(producto: Producto)

    //Editar una vez se tengan los daos correspondientes
    @Query("SELECT * FROM UnidadMedida where estado<>3")
    suspend fun getUnidades():List<UnidadMedida>

    @Query("SELECT * FROM UnidadMedida where id_unidad = :id")
    suspend fun getUnidadById(id:Int): UnidadMedida

    @Query("SELECT * FROM Categoria where estado<>3")
    suspend fun getCategoria():List<Categoria>

    @Query("SELECT * FROM Categoria where id_categoria = :id")
    suspend fun getCategoriaById(id:Int): Categoria
}