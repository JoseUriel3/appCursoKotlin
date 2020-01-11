package com.mx.smartsoftamerica

import android.os.Bundle
import android.os.PersistableBundle
import android.view.textclassifier.TextLinks
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.mx.smartsoftamerica.bo.Usuario
import java.sql.Time
import java.util.ArrayList

class Vista:AppCompatActivity(), VistaInterface {

    lateinit var vistaAdapter: VistaAdapter
    var listaUsuarios:MutableList<Usuario> = ArrayList()
    var request:RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista)
        request = Volley.newRequestQueue(this)
        obtenerDatos()
    }

    override fun mostrarInformacion(dato: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun obtenerDatos(){
        val url = "http://www.mocky.io/v2/5e0f941d3400005cc22d8122"
        var contador = 0
        var requestArray = JsonArrayRequest(Request.Method.GET,url,null, Response.Listener {
            success ->
            while (contador<success.length()){
                listaUsuarios.add(Gson().fromJson(success[contador].toString(), Usuario::class.java))
                contador++
            }
            if(listaUsuarios.isNotEmpty()){
                Toast.makeText(this, listaUsuarios.toString(), Toast.LENGTH_LONG).show()
            }
        }, Response.ErrorListener {
            error ->
            when(error){
                is ServerError -> Toast.makeText(this, "ServerError", Toast.LENGTH_SHORT).show()
                is TimeoutError -> Toast.makeText(this, "TimeoutError", Toast.LENGTH_SHORT).show()
                is NoConnectionError -> Toast.makeText(this, "NoConnectionError", Toast.LENGTH_SHORT).show()
                is NetworkError -> Toast.makeText(this, "NetworkError", Toast.LENGTH_SHORT).show()
                is AuthFailureError -> Toast.makeText(this, "AuthFailureError", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "ElseError", Toast.LENGTH_SHORT).show()
            }
        })
        request!!.add(requestArray).retryPolicy = DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

    }

}