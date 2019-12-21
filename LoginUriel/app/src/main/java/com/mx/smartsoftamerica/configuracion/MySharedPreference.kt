package com.mx.smartsoftamerica.configuracion

import android.content.Context
import android.content.SharedPreferences

class MySharedPreference(context: Context) {
    private val settins: SharedPreferences =
        context.getSharedPreferences("MySharedPreference", Context.MODE_PRIVATE)
    var usuario: String
        get() = settins.getString("usuarioSesion", "")!!
        set(value) = settins.edit().putString("usuarioSesion", value).apply()

    fun cerrarSesion(){
        settins.edit().remove("usuarioSesion").apply()
    }
}