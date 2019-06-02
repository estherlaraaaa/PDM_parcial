package com.estherlara.pdm_parcial.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.database.entities.Team
import com.estherlara.pdm_parcial.viewModel.ViewModel

class newTeamActivity : AppCompatActivity() {

    private lateinit var et_nameTeam : EditText
    private lateinit var et_pointsTeam : EditText
    private lateinit var et_dateTeam : EditText
    private lateinit var et_timeTeam : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_team)

        val viewmodel = ViewModelProviders.of(this).get(ViewModel::class.java)
        et_nameTeam = findViewById(R.id.et_nameTeam)
        et_pointsTeam = findViewById(R.id.et_pointsTeam)
        et_dateTeam = findViewById(R.id.et_dateTeam)
        et_timeTeam = findViewById(R.id.et_timeTeam)

        val button = findViewById<Button>(R.id.btn_agregar)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(et_nameTeam.text) || TextUtils.isEmpty(et_pointsTeam.text) || TextUtils.isEmpty(
                    et_dateTeam.text
                ) || TextUtils.isEmpty(et_timeTeam.text)
                )
             {
                //setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {


                val nameTeam = et_nameTeam.text.toString()
                val pointsTeam = et_pointsTeam.text.toString()
                val dateTeam = et_dateTeam.text.toString()
                val timeTeam = et_timeTeam.text.toString()

                try {
                    viewmodel.insertTeam(Team(nameTeam, pointsTeam, dateTeam, timeTeam))

                    Toast.makeText(this, "Se agrego el equipo correctamente", Toast.LENGTH_SHORT).show()
                } catch (e: android.database.sqlite.SQLiteConstraintException) {
                    Toast.makeText(this, "ups! algo puso mal ", Toast.LENGTH_SHORT).show()

                }

                /*replyIntent.putExtra(EXTRA_REPLY, name)
                setResult(Activity.RESULT_OK, replyIntent)*/
            }
            finish()
        }
    }
}