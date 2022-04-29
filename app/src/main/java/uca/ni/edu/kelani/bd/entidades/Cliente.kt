package uca.ni.edu.kelani.bd.entidades

data class Cliente (
    val id_cliente:Int,
    val nombre:String,
    val apellido:String,
    val telefono:String,
    val cedula:String,
    val activo: Boolean,
    val direccion:String
    )