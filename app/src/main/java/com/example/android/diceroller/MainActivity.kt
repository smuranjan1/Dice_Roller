package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var diceText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Lets Roll"
        rollButton.setOnClickListener {
            rollButton.text = "Roll Again"
            Toast.makeText(this, "Rolling...", Toast.LENGTH_SHORT).show()
            rollDice()
        }
        diceText = findViewById(R.id.dice_text)
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice()
    {
        val randomInt = Random.nextInt(6) + 1
        val drawableResource = when (randomInt)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val diceString = when (randomInt)
        {
            1 -> "You rolled a 1."
            2 -> "You rolled a 2."
            3 -> "You rolled a 3."
            4 -> "You rolled a 4."
            5 -> "You rolled a 5."
            else -> "You rolled a 6."
        }
        diceImage.setImageResource(drawableResource)
        diceText.text = diceString
    }
}