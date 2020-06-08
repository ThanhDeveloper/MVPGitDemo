package com.example.mvpgitdemo.data.model

data class CoronaVirus (
    var name: String,
    var description: String,
    var path: String
)

object CoronaEntry {
    const val OBJECT = "countriesRoute"
    const val NAME   = "Name"
    const val DESC   = "Description"
    const val PATH   = "Path"
}