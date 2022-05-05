package ni.edu.uca.peliculas50.bd.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uca.ni.edu.kelani.bd.dao.*
import uca.ni.edu.kelani.bd.entidades.*
import uca.ni.edu.kelani.bd.entidades.views.vw_Factura
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet

interface MainDataBaseProvider{
    fun facturaDao():FacturaDao
    fun facturaDetDao(): FacturaDetDao
    fun categoriatDao(): CategoriaDao
    fun unidadtDao(): UnidadMedidaDao
    fun clienteDao(): ClienteDao
}

@Database(
    entities = [Categoria::class, UnidadMedida::class,Producto::class,Cliente::class,Usuario::class,Factura::class,FacturaDet::class],
    views=[vw_Factura::class,vw_FacturaDet::class],
    version =3)
abstract class bdKealni: RoomDatabase(), MainDataBaseProvider {

    abstract override fun facturaDao(): FacturaDao
    abstract override fun facturaDetDao(): FacturaDetDao
    abstract override fun categoriatDao(): CategoriaDao
    abstract override fun unidadtDao(): UnidadMedidaDao
    abstract override fun clienteDao(): ClienteDao

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