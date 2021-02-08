package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import kotlin.random.nextInt

enum class Sides(val num:Int){
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);
}

private var maxNum = Sides.SIX.num
lateinit var diceImage: ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{ rollDice() }
    }

    /*
     * Roll dice and change displayed value.
     */
    fun rollDice(){
        diceImage = findViewById(R.id.dice_image)
        diceImage.setImageResource(roll(maxNum))
    }

    /*
     * Generate random integer between one and maximum number.
     */
    private fun roll(maxNum:Int): Int {
        return when(Random.nextInt(Sides.ONE.num..maxNum)){
            Sides.ONE.num -> R.drawable.dice_1
            Sides.TWO.num -> R.drawable.dice_2
            Sides.THREE.num -> R.drawable.dice_3
            Sides.FOUR.num -> R.drawable.dice_4
            Sides.FIVE.num -> R.drawable.dice_5
            Sides.SIX.num -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }
}