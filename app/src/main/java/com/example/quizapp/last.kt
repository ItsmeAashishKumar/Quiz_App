package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class last : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        val scoreT=findViewById<TextView>(R.id.score)

        val userName=findViewById<TextView>(R.id.user)
        val finish=findViewById<Button>(R.id.btn)


        val getUser=intent.getStringExtra(Constant.User_Name)
        val rScore=intent.getIntExtra(Constant.correctAnswer,0)
        val tScore=intent.getIntExtra(Constant.wronganswer,0)



        scoreT.text="$rScore"+"/"+"$tScore"



        userName.text=getUser
        finish.setOnClickListener(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}