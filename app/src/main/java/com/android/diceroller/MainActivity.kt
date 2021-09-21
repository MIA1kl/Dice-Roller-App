package com.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollBtn.setOnClickListener {
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

        diceImg1.setImageResource(drawableResource1)
        diceImg2.setImageResource(drawableResource2)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val savedName : Int = drawableResource1
        val savedName2 : Int = drawableResource2
        outState.putInt("savedString", drawableResource1)
        outState.putInt("savedString2", drawableResource2)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedVal :Int = savedInstanceState.getInt("savedString",0)
        val savedVal2 :Int = savedInstanceState.getInt("savedString2",0)
        drawableResource1 = savedVal
        drawableResource2 = savedVal2
        diceImg1.setImageResource(drawableResource1)
        diceImg2.setImageResource(drawableResource2)
    }
}