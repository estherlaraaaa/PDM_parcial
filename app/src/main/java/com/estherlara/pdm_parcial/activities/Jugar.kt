package com.estherlara.pdm_parcial.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.database.entities.Game
import com.estherlara.pdm_parcial.databinding.PlayGameBinding
import com.estherlara.pdm_parcial.viewModel.ViewModel
import kotlinx.android.synthetic.main.play_game.*
import java.text.SimpleDateFormat
import java.util.*

class Jugar : AppCompatActivity(), LifecycleOwner {

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_game)

        val binding = DataBindingUtil.setContentView(this, R.layout.play_game) as PlayGameBinding

        val tvEquipoA : TextView  = findViewById<TextView>(R.id.tv_equipoA) as TextView
        val tvEquipoB : TextView = findViewById<TextView>(R.id.tv_equipoB) as TextView
        val btnFinish : Button = findViewById<Button>(R.id.btn_finish)
        val btn1A : Button = findViewById(R.id.btn_masuno_a)
        val btn2A : Button = findViewById(R.id.btn_masdos_a)
        val btn3A : Button = findViewById(R.id.btn_mastres_a)
        val btn1B : Button = findViewById(R.id.btn_masuno_b)
        val btn2B : Button = findViewById(R.id.btn_masdos_b)
        val btn3B : Button = findViewById(R.id.btn_mastres_b)
        val btnreset : Button = findViewById(R.id.bt_reset)

        val equipoA = intent.getStringExtra("EquipoA")
        val equipoB = intent.getStringExtra("EquipoB")

        tvEquipoA.text = equipoA
        tvEquipoB.text = equipoB

        //Equipo A AGREGAR PUNTOS
    btn1A.setOnClickListener {
        scoreViewModel.scoreTeamA += 1
        scoreViewModel.currentScoreA.value = scoreViewModel.scoreTeamA
    }
        btn2A.setOnClickListener {
            scoreViewModel.scoreTeamA += 2
            scoreViewModel.currentScoreA.value = scoreViewModel.scoreTeamA
        }
        btn3A.setOnClickListener {
            scoreViewModel.scoreTeamA += 3
            scoreViewModel.currentScoreA.value = scoreViewModel.scoreTeamA
        }
        //Equipo B agregar puntos
        btn1B.setOnClickListener {
            scoreViewModel.scoreTeamB += 1
            scoreViewModel.currentScoreB.value = scoreViewModel.scoreTeamB
        }
        btn2B.setOnClickListener {
            scoreViewModel.scoreTeamB += 2
            scoreViewModel.currentScoreB.value = scoreViewModel.scoreTeamB
        }
        btn3B.setOnClickListener {
            scoreViewModel.scoreTeamB += 3
            scoreViewModel.currentScoreB.value = scoreViewModel.scoreTeamB
        }
        //reset puntos
        btnreset.setOnClickListener {
            scoreViewModel.scoreTeamB = 0
            scoreViewModel.currentScoreB.value = scoreViewModel.scoreTeamB

            scoreViewModel.scoreTeamA = 0
            scoreViewModel.currentScoreA.value = scoreViewModel.scoreTeamA
        }


        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        val viewmodel = ViewModelProviders.of(this).get(ViewModel::class.java)


        binding.scoreTeam = scoreViewModel

        val puntosAObserver = Observer<Int> { newInt ->

            tv_score_team_a.text = newInt.toString()
        }
        val puntosBObserver = Observer<Int> { newInt ->

            tv_score_team_b.text = newInt.toString()
        }

        scoreViewModel.currentScoreA.observe(this, puntosAObserver)
        scoreViewModel.currentScoreB.observe(this,puntosBObserver)

        btnFinish.setOnClickListener {
            val scoreA = tv_score_team_a.text.toString()
            val scoreB = tv_score_team_b.text.toString()

            //fecha
            val date = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val date2 = date.format(Date())


            //validando quien gano
            if(scoreB.toInt() > scoreA.toInt()){
                viewmodel.insert(Game(tvEquipoA.text.toString(),tvEquipoB.text.toString(),scoreA.toInt(),scoreB.toInt(),date2,tvEquipoB.text.toString()))
                finish()
            }else if(scoreB.toInt() < scoreA.toInt()){
                viewmodel.insert(Game(tvEquipoA.text.toString(),tvEquipoB.text.toString(),scoreA.toInt(),scoreB.toInt(),date2,tvEquipoA.text.toString()))
                finish()
            }else if(scoreB.toInt() == scoreA.toInt()){
                viewmodel.insert(Game(tvEquipoA.text.toString(),tvEquipoB.text.toString(),scoreA.toInt(),scoreB.toInt(),date2,"Empate"))
                finish()

            }

            //mandandome de nuevo a la pantalla principal
            startActivity(Intent(this, MainActivity::class.java))

        }


    }







}