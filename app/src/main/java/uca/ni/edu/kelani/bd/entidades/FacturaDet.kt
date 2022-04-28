package uca.ni.edu.kelani.bd.entidades


data class FacturaDet(
    val id_factura_det:Int,
    val id_producto:Int,
    val cantidad:Int,
    val subtotal:Double
)