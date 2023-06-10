package com.example.quizapp

object Constant{

    const val User_Name:String="user_name"
    const val correctAnswer:String="correct"
    const val wronganswer:String="wrong"
    fun GetQuestions():ArrayList<questions> {

        val questionlist=ArrayList<questions>()

        val q1=questions(1,
            "What Country does this flag belong to ?",
            R.drawable.argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )

        val q2=questions(2,
            "What Country does this flag belong to ?",
            R.drawable.bangladesh,
            "Pakistan",
            "Japan",
            "India",
            "Bangladesh",
            4
        )

        val q3=questions(3,
            "What Country does this flag belong to ?",
            R.drawable.brazil,
            "Ghana",
            "Zimbabwe",
            "Brazil",
            "South Africa",
            3
        )

        val q4=questions(4,
            "What Country does this flag belong to ?",
            R.drawable.germany,
            "Argentina",
            "Germany",
            "Armenia",
            "Poland",
            2
        )

        val q5=questions(5,
            "What Country does this flag belong to ?",
            R.drawable.ghana,
            "Ghana",
            "Serbia",
            "Armenia",
            "Sudan",
            1
        )

        val q6=questions(6,
            "What Country does this flag belong to ?",
            R.drawable.india,
            "Nepal",
            "Sri Lanka",
            "India",
            "Austria",
            3
        )

        val q7=questions(7,
            "What Country does this flag belong to ?",
            R.drawable.itly,
            "Serbia",
            "Itly",
            "Slovenia",
            "Austria",
            2
        )

        val q8=questions(8,
            "What Country does this flag belong to ?",
            R.drawable.japan,
            "Japan",
            "Bahrain",
            "China",
            "Bahamas",
            1
        )

        val q9=questions(9,
            "What Country does this flag belong to ?",
            R.drawable.nepal,
            "Sri Lanka",
            "India",
            "Afghanistan",
            "Nepal",
            4
        )

        val q10=questions(10,
            "What Country does this flag belong to ?",
            R.drawable.southafrica,
            "South America",
            "South Sudan",
            "South Africa",
            "Austria",
            3
        )


        questionlist.add(q1)
        questionlist.add(q2)
        questionlist.add(q3)
        questionlist.add(q4)
        questionlist.add(q5)
        questionlist.add(q6)
        questionlist.add(q7)
        questionlist.add(q8)
        questionlist.add(q9)
        questionlist.add(q10)

        return questionlist

    }
}