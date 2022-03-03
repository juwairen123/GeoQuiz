package com.example.geoquiz

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModel

class QuizViewModel: ViewModel() {
    var currentIndex = 0
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    var isCheater:Boolean = false
    val currentQuestionAnswer: Boolean get() = questionBank[currentIndex].answer
    val currentQuestionText: Int get() = questionBank[currentIndex].textResId
    fun moveToNext(){
        currentIndex = (currentIndex + 1)%questionBank.size
    }

}