package com.mx.smartsoftamerica.inicio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mx.smartsoftamerica.Bienvenido
import com.mx.smartsoftamerica.aplicacion.settings
import com.mx.smartsoftamerica.ui.login.LoginActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(settings.usuario.isEmpty()){
            startActivity(Intent(this,LoginActivity::class.java))
        }else{
            startActivity(Intent(this,Bienvenido::class.java))
        }
        finish()
    }
}