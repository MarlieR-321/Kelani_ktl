package uca.ni.edu.kelani.bd.entidades.views


data class vw_FacturaDet(
    val id_factura_det:Int,
    val id_producto:Int,
    val id_factura:Int,
    val producto:String,
    val precio:Double,
    val cantidad:Int,
    val subtotal:Double
)