package com.mx.smartsoftamerica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.smartsoftamerica.aplicacion.settings
import com.mx.smartsoftamerica.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_bienvenido.*

class Bienvenido : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)
        var correo = settings.usuario
        textViewBienvenido.text = correo
        btnSalir.setOnClickListener {
            settings.cerrarSesion()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
        btnIrFormulario.setOnClickListener {
            startActivity(Intent(this,Formulario::class.java))
        }

    }
}
