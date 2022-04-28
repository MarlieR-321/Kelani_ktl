package uca.ni.edu.kelani.bd.entidades.views


data class vw_FacturaEnc(
    val id_factura:Int,
    val fecha:String,
    val id_cliente:Int,
    val nombre_cliente:String,
    val telefono:String,
    val direccion:String,
    val total:Int
)