package com.estherlara.pdm_parcial.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.estherlara.pdm_parcial.R

class MainActivity : AppCompatActivity() {
    var btn_game : Button?=null
    var btn_verGame : Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.opc_inicio)


        btn_game = findViewById(R.id.btn_play)
        btn_verGame = findViewById(R.id.btn_ver_game)

        btn_game?.setOnClickListener{

            startActivity(Intent(this, nameTeams::class.java))
        }

        btn_verGame?.setOnClickListener {
            startActivity(Intent(this, verGames::class.java))
        }
    }
}
