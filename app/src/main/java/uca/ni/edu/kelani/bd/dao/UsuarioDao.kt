package uca.ni.edu.kelani.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.Usuario

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  isert(usuario: Usuario)

    @Query("SELECT * FROM Usuario where estado<>3")
    suspend fun getAll(): List<Usuario>

    @Query("SELECT * FROM Usuario where estado<>3")
    fun getAllRealData(): LiveData<List<Usuario>>

    @Query("SELECT * FROM Usuario WHERE id_usuario = :id")
    suspend fun getById(id : Int) : Usuario

    @Update
    suspend fun update(usuario: Usuario)

    //Inutilizable el delete por cambiar el estado a 3
    @Delete
    suspend fun delete(usuario: Usuario)

    //VERIFICACION DEL USUARIO
    @Query("SELECT * FROM Usuario WHERE username= :usur AND pwd= :pwd AND estado<>3")
    suspend fun getVerif(usur:String, pwd: String) : Usuario

}