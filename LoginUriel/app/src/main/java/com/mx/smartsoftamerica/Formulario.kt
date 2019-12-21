package com.mx.smartsoftamerica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_formulario.*

class Formulario : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var sexoSeleccionado = ""
    var lista = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        spnSexo.onItemSelectedListener = this


        lista.add("Seleccione")
        lista.add("Masculino")
        lista.add("Femenino")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnSexo.adapter = adapter
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        sexoSeleccionado = lista[position]
        Toast.makeText(this, "Seleccionado: $sexoSeleccionado",Toast.LENGTH_LONG)
    }
}
