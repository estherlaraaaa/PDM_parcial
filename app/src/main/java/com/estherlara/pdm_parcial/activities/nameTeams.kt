package com.estherlara.pdm_parcial.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.estherlara.pdm_parcial.R

class nameTeams : AppCompatActivity() {
    var et_teamA : EditText ?= null
    var et_teamB : EditText ?= null
    var btnStart : Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_team)

        et_teamA = findViewById(R.id.et_equipoA)
        et_teamB = findViewById(R.id.et_equipoB)
        val et_teamAString : String = et_teamA?.text.toString()
        val et_teamBString : String = et_teamB?.text.toString()
        btnStart = findViewById(R.id.btn_Comenzar)

        btnStart?.setOnClickListener {
                val intent = Intent(this@nameTeams, Jugar::class.java)
                intent.putExtra("EquipoA", et_teamA?.text.toString())
                intent.putExtra("EquipoB", et_teamB?.text.toString())
                startActivity(intent)
        }
    }
}

