package com.example.taller4.Interface

interface IComunicaFragments {
    fun sendTeam(nameTeam: String, pointsTeam: String, dateTeam: String, timeTeam: String)

    fun sendMatch(nameMatch: String, teamA: String, teamB: String, date: String, time: String, pointsTeamA: String, pointsTeamB: String, win: String)
}