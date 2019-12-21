package com.mx.smartsoftamerica.aplicacion

import android.app.Application
import com.mx.smartsoftamerica.configuracion.MySharedPreference

val settings: MySharedPreference by lazy { Aplicacion.configuraciones!! }

class Aplicacion : Application() {
    companion object {
        var configuraciones: MySharedPreference? = null
    }

    override fun onCreate() {
        super.onCreate()
        configuraciones = MySharedPreference(applicationContext)
    }
}