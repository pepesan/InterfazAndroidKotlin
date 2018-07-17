package com.cursosdedesarrollo.interfazandroidkotlin

class Movie {
    var title: String? = null
    var genre: String? = null
    var year: String? = null

    constructor() {
        this.title = ""
        this.genre = ""
        this.year = ""
    }

    constructor(title: String, genre: String, year: String) {
        this.title = title
        this.genre = genre
        this.year = year
    }
}