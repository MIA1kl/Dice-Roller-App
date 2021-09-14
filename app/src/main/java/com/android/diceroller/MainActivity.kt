package com.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn : Button = findViewById(R.id.rollBtn)
        btn.setOnClickListener {
            rollDice()
        }

    }
    var drawableResource1= R.drawable.dice_1
    var drawableResource2 = R.drawable.dice_1

    private fun rollDice() {
        val randomInt1 = Random.nextInt(6)+1
        val randomInt2 = Random.nextInt(6)+1
        drawableResource1 = when(randomInt1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        drawableResource2 = when(randomInt2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val diceImg1:ImageView = findViewById(R.id.diceImg1)
        val diceImg2:ImageView = findViewById(R.id.diceImg2)

        diceImg1.setImageResource(drawableResource1)
        diceImg2.setImageResource(drawableResource2)
    }
}