package com.estherlara.pdm_parcial.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.adapters.MatchAdapter
import com.estherlara.pdm_parcial.viewModel.ViewModel

class showMatch : AppCompatActivity(), LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_match)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_match)
        val adapter = this.let { MatchAdapter(this) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)




        val viewmodel = ViewModelProviders.of(this).get(ViewModel::class.java)

        viewmodel.allMatch.observe(this, Observer { match->
            match?.let {

                adapter?.setMatch(match)

            }
        })
    }
}