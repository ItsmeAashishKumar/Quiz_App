package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)



        binding.start.setOnClickListener(){
            if(binding.etName.text.toString().isEmpty()){
                Toast.makeText(this,"Enter your Name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent= Intent(this,QuizQuestions::class.java)
                intent.putExtra(Constant.User_Name,binding.etName.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}