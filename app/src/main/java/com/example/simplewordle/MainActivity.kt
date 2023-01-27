package com.example.simplewordle

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

                if (counter == 1) {
                    resultText.text = res
                    guess1.text = "Guess 1: $guess"
                }
                else if (counter == 2) {
                    resultText2.text = res
                    guess2.text = "Guess 2: $guess"
                }
                else {
                    resultText3.text = res
                    guess3.text = "Guess 3: $guess"
                    Toast.makeText(it.context, "The correct word is $word", Toast.LENGTH_SHORT).show()
                }

            }
            else {
                Toast.makeText(it.context, "Exceeded number of guesses!", Toast.LENGTH_SHORT).show()


            }

        }


    }
    private fun checkGuess(guess: String, wordToGuess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

}

