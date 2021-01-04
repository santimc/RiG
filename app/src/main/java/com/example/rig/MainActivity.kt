package com.example.rig

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apparatusButton: Button = findViewById(R.id.button)
        apparatusButton.setOnClickListener() {
            chooseApparatus()
        }
    }

    private fun chooseApparatus() {
        //Create 6 sided dice and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Get apparatusImage from the layout
        val apparatusImage: ImageView = findViewById(R.id.imageView)
        //Get apparatusText from the layout
        val apparatusText: TextView = findViewById(R.id.textView)
        //Determine image Id based on dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.hoop
            2 -> R.drawable.ribbon
            3 -> R.drawable.clubs
            4 -> R.drawable.ball
            5 -> R.drawable.rope
            else -> R.drawable.nothing
        }
        //Determine text based on dice roll
        val apparatusContent = when (diceRoll) {
            1 -> "Hoop"
            2 -> "Ribbon"
            3 -> "Clubs"
            4 -> "Ball"
            5 -> "Rope"
            else -> "Free Hands"
        }
        //Update Image with correct drawable
        apparatusImage.setImageResource(drawableResource)
        //Update Text
        apparatusText.text = apparatusContent
        //Update Image description with correct number
        apparatusImage.contentDescription = apparatusContent
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}