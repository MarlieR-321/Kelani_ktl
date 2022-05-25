package uca.ni.edu.kelani.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uca.ni.edu.kelani.network.service.*

object Api {

    private const val BASE_URL : String = "http://kelani.herokuapp.com/"

    private val loggingInterceptor : HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val okHttpClient : OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()


    private val retrofit : Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val categoriaService : CategoriaService =
        retrofit.create(CategoriaService::class.java)

    val facturaService:FacturaService=
        retrofit.create(FacturaService::class.java)

    val facturaDetService:FacturaDetService=
        retrofit.create(FacturaDetService::class.java)

    val clienteService:ClienteService=
        retrofit.create(ClienteService::class.java)

    val usuarioService:UsuarioService=
        retrofit.create(UsuarioService::class.java)

    val productoService:ProductoService=
        retrofit.create(ProductoService::class.java)

}