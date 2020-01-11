package com.mx.smartsoftamerica.bo

import java.io.Serializable

data class Usuario(val id:Int, val name: String, val email:String, val gender: String, val contact: Contacto) : Serializable