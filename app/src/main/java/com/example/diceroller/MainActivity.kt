package com.example.diceroller

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import kotlin.random.nextInt

enum class Sides(val num:Int){
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);
}
private var numSides = Sides.SIX.num

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val decreaseButton: Button = findViewById(R.id.decrease_button)
        var diceImage:ImageView = findViewById(R.id.dice_image)
        decreaseButton.text = getString(R.string.decrease_string).plus(" ") + (numSides-1)
        decreaseButton.setOnClickListener{decreaseSides(decreaseButton)}
        rollButton.setOnClickListener{ rollDice(diceImage) }
    }

    /*
     * Roll dice and change displayed value.
     */
    private fun rollDice(diceImage: ImageView){
        diceImage.setImageResource(roll(numSides))
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

    /*
     * Decrement the number of sides.
     */
    private fun decreaseSides(decreaseButton: Button){
        numSides--
        decreaseButton.visibility = if(numSides == 1) GONE else VISIBLE
        decreaseButton.text = getString(R.string.decrease_string).plus(" ") + (numSides-1)
    }
}