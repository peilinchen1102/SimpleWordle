package com.example.simplewordle

import android.app.Activity
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val word = FourLetterWordList.getRandomFourLetterWord()
        //val word = "HOME"
        val resultText = findViewById<TextView>(R.id.resultText)
        val resultText2 = findViewById<TextView>(R.id.resultText2)
        val resultText3 = findViewById<TextView>(R.id.resultText3)

        val guess1= findViewById<TextView>(R.id.guess1)
        val guess2= findViewById<TextView>(R.id.guess2)
        val guess3= findViewById<TextView>(R.id.guess3)



        button.setOnClickListener {

            counter++
            var guess = findViewById<TextInputLayout>(R.id.textInputLayout3).editText?.text.toString().uppercase()
            // Guess 3 times
            if (counter <= 3) {
                var res = checkGuess(guess, word)

                if (guess == word) {


                }

                if (counter == 1) {
                    resultText.text = res
                }
                else if (counter == 2) {
                    resultText2.text = res
                }
                else {
                    resultText3.text = res
                    Toast.makeText(it.context, "The correct word is $word", Toast.LENGTH_SHORT).show()
                }

            }
            else {
                Toast.makeText(it.context, "Exceeded number of guesses!", Toast.LENGTH_SHORT).show()


            }

        }


    }
    private fun checkGuess(guess: String, wordToGuess: String) : Spannable {
        var result = ""


        val res = SpannableString(guess)

        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
                res.setSpan(ForegroundColorSpan(Color.GREEN), i, i+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

            }
            else if (guess[i] in wordToGuess) {
                result += "+"
                res.setSpan(ForegroundColorSpan(Color.YELLOW), i, i+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            }
            else {
                result += "X"
                res.setSpan(ForegroundColorSpan(Color.RED), i, i+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            }
        }
//        val final = SpannableString(result)
//        for (i in 0..3) {
//            if (result[i] =='X') {
//                final.setSpan(ForegroundColorSpan(Color.RED), i, i+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
//            }
//            if (result[i] == 'O') {
//                final.setSpan(ForegroundColorSpan(Color.GREEN), i, i+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
//            }
//            if (result[i] == '+') {
//                final.setSpan(ForegroundColorSpan(Color.YELLOW), i, i+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
//            }
//        }
        return res
    }

}

