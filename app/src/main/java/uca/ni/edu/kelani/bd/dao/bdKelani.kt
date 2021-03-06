package uca.ni.edu.kelani.bd.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uca.ni.edu.kelani.bd.entidades.*
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet
import uca.ni.edu.kelani.bd.entidades.views.vw_Producto

interface MainDataBaseProvider{
    fun facturaDao():FacturaDao
    fun facturaDetDao(): FacturaDetDao
    fun categoriatDao(): CategoriaDao
    fun unidadtDao(): UnidadMedidaDao
    fun clienteDao(): ClienteDao
    fun usuarioDao(): UsuarioDao
    fun productoDao(): ProductoDao
}

@Database(
    entities = [Categoria::class, UnidadMedida::class,Producto::class,Cliente::class,Usuario::class,Factura::class,FacturaDet::class],
    views=[vw_Factura::class,vw_FacturaDet::class,vw_Producto::class],
    version =7)
abstract class bdKealni: RoomDatabase(), MainDataBaseProvider {

    abstract override fun facturaDao(): FacturaDao
    abstract override fun facturaDetDao(): FacturaDetDao
    abstract override fun categoriatDao(): CategoriaDao
    abstract override fun unidadtDao(): UnidadMedidaDao
    abstract override fun clienteDao(): ClienteDao
    abstract override fun usuarioDao(): UsuarioDao
    abstract override fun productoDao(): ProductoDao

    companion object {
        @Volatile
        private var INSTANCE: bdKealni? = null
        fun getDataBase(context: Context): bdKealni {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        bdKealni::class.java,
                        "kelani_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}