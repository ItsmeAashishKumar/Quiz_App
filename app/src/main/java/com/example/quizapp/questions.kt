package com.example.quizapp

data class questions(
    val id:Int,
    val question:String,
    val Image:Int,
    val OptionOne:String,
    val OptionTwo:String,
    val OptionThree:String,
    val OptionFour:String,
    val correctAnswer:Int
)