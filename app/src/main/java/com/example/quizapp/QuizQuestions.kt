package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity(), OnClickListener{


    lateinit var btn_submit:Button
    lateinit var questionText:TextView
    lateinit var pic:ImageView
    lateinit var optionOne:TextView
    lateinit var optionTwo:TextView
    lateinit var optionThree:TextView
    lateinit var optionFour:TextView


    private var mCurrentposition:Int=1
    private var mQuestionList:ArrayList<questions>?=null
    private var mSelectedOptionPosition:Int=0
    private var mUsername:String?=null
    private var correcAnswer:Int=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        btn_submit=findViewById(R.id.submit)

        mQuestionList=Constant.GetQuestions()
        mUsername=intent.getStringExtra(Constant.User_Name)
        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)





    }

    fun setQuestion(){

         questionText=findViewById(R.id.quetext)
         optionOne=findViewById<TextView>(R.id.option1)
            optionTwo=findViewById<TextView>(R.id.option2)
         optionThree=findViewById<TextView>(R.id.option3)
         optionFour=findViewById<TextView>(R.id.option4)
        val pic=findViewById<ImageView>(R.id.image)

        val questions=mQuestionList!![mCurrentposition-1]
        defaultOptionview()

        if(mCurrentposition==mQuestionList!!.size){
            btn_submit.text="FINISH"
        }
        else{
            btn_submit.text="SUBMIT"
        }

        val progressno=findViewById<TextView>(R.id.progressNo)
        val progressbar=findViewById<ProgressBar>(R.id.progressBar)
        progressbar.progress=mCurrentposition
        progressno.text="$mCurrentposition"+"/"+progressbar.max

        questionText.text=questions!!.question
        pic.setImageResource(questions.Image)
        optionOne.text=questions.OptionOne
        optionTwo.text=questions.OptionTwo
        optionThree.text=questions.OptionThree
        optionFour.text=questions.OptionFour
    }

    private fun defaultOptionview(){
        val options =ArrayList<TextView>()
        options.add(0,optionOne)
        options.add(1,optionTwo)
        options.add(2,optionThree)
        options.add(3,optionFour)

        for(option in options){
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this,R.drawable.bg)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option1->{
                selectedOptionView(optionOne,1)
            }
            R.id.option2->{
                selectedOptionView(optionTwo,2)
            }
            R.id.option3->{
                selectedOptionView(optionThree,3)
            }
            R.id.option4->{
                selectedOptionView(optionFour,4)
            }
            R.id.submit->{
                if(mSelectedOptionPosition==0){
                    mCurrentposition++

                    when{
                        mCurrentposition<=mQuestionList!!.size->{
                            setQuestion()
                        }
                        else->{
                            val intent= Intent(this,last::class.java)
                            intent.putExtra(Constant.User_Name,mUsername)
                            intent.putExtra(Constant.correctAnswer,correcAnswer)
                            intent.putExtra(Constant.wronganswer,mQuestionList!!.size)
                            startActivity(intent)
                            finish()


                        }
                    }
                }
                else{
                    val question=mQuestionList?.get(mCurrentposition-1)
                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option)
                    }
                    else{
                        correcAnswer++
                    }
                        answerView(question.correctAnswer,R.drawable.correct_option)

                        if(mCurrentposition==mQuestionList!!.size){
                            btn_submit.text="FINISH"
                        }
                        else{
                            btn_submit.text="NEXT"
                        }
                        mSelectedOptionPosition=0

                }
            }
        }
    }
    private fun answerView(answer :Int ,drawableView:Int){
        when(answer){
            1->{
                optionOne.background=ContextCompat.getDrawable(this,
                drawableView)
            }
            2->{
                optionTwo.background=ContextCompat.getDrawable(this,
                    drawableView)
            }
            3->{
                optionThree.background=ContextCompat.getDrawable(this,
                    drawableView)
            }
            4->{
                optionFour.background=ContextCompat.getDrawable(this,
                    drawableView)
            }

        }
    }

    private fun selectedOptionView(tv:TextView , selecedOptoin:Int){
        defaultOptionview()
        mSelectedOptionPosition=selecedOptoin
        tv.setTextColor(Color.parseColor("#000000"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(this,R.drawable.bg2)

    }
}