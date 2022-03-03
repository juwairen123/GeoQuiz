package com.example.geoquiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val EXTRA_ANSWER_IS_TRUE = "com.example.geoquiz.answer_is_true"
class CheatActivity : AppCompatActivity() {
    lateinit var answerTextView:TextView
    lateinit var showAnswerButton: Button
    private var answerIsTrue = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
        answerTextView = findViewById(R.id.answer_text_view)
        showAnswerButton = findViewById(R.id.show_answer_button)
        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false)
        showAnswerButton.setOnClickListener {
            val answerText = when(answerIsTrue){
                true -> R.string.true_button
                else -> R.string.false_button
            }
            answerTextView.setText(answerText)
            val data = Intent().apply {
                putExtra(EXTRA_ANSWER_IS_TRUE,true)
            }
            setResult(RESULT_OK,data)
        }
    }
    companion object{
        fun newIntent(packageContext: Context, answerIsTrue:Boolean): Intent {
            val intent = Intent(packageContext,CheatActivity::class.java)
            intent.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue)
            return intent
        }
    }
}