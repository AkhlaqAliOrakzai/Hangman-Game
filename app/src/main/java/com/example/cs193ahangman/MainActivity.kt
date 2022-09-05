package com.example.cs193ahangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils.indexOf
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var arr = arrayOf("apples","potatoes","mathematics","programming","functionality")
    var i = (0..4).random()
    var toGuess = arr[i]

    var guessed = ""
    var newMsg = ""
    var guessLeft:Int ? = null

    fun playAgain(){
        //just pasting all the code which i did when application started

        i = (0..4).random()
        toGuess = arr[i]

        guessed = ""
        newMsg = ""
        guessLeft = null

        var totalGuessed = findViewById<TextView>(R.id.textView3)
        totalGuessed.setText("You have guessed: nothing")

        var message = findViewById<TextView>(R.id.textView2)
        message.setText("")
        for(i in 0..toGuess.length-1){
            message.setText(message.text.toString()+"?")
        }
    }

    fun newClick(view:View){
        playAgain()
    }
    fun guessClick(view: View){
        var msg = findViewById<TextView>(R.id.textView2)
        var inp = findViewById<EditText>(R.id.input)
        newMsg = msg.text.toString()
        var arr = newMsg.toCharArray()

        guessed+= inp.text.toString()
        var count = 0 ;
            for (i in toGuess.indices) {
                if (toGuess[i].toString() == inp.text.toString()) {

                    arr[i] = toGuess[i]
                    count++
                    if(count>1){
                        guessed += toGuess[i]
                        count--
                    }
                }
            }

            msg.setText(String(arr))
            if(guessLeft!=0){
                guessLeft = toGuess.length - guessed.length
            }
            if(guessLeft==0 && toGuess != String(arr)){
                Toast.makeText(
                    this,
                    "Oops... You lost the match...",
                    Toast.LENGTH_LONG
                ).show()
            }
            else if(guessLeft == 0 && toGuess == String(arr) ){
                Toast.makeText(
                    this,
                    "Hurrah... You won the match...",
                    Toast.LENGTH_LONG
                ).show()
            }
            else if(toGuess == String(arr)){
                Toast.makeText(
                    this,
                    "Hurrah... You won the match...",
                    Toast.LENGTH_LONG
                ).show()
            }

        var totalGuessed = findViewById<TextView>(R.id.textView3)
        totalGuessed.setText("You have guessed: " + guessed + " (" + (guessLeft) + " guesses left)")
    }

    override fun onStart() {
        super.onStart()
        var message = findViewById<TextView>(R.id.textView2)
        message.setText("")
        for(i in 0..toGuess.length-1){
            message.setText(message.text.toString()+"?")
        }
    }

}