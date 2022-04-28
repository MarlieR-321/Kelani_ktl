package uca.ni.edu.kelani.bd.entidades


data class FacturaEnc(
    val id_factura:Int,
    val fecha:String,
    val id_cliente:Int,
    val telefono:String,
    val direccion:String,
    val total:Int
)