package com.example.diceroller

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    private var minSides = 1
    private var maxSides = 6
    private lateinit var sideResources: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sideResources = listOf(R.drawable.empty_dice, R.drawable.dice_1, R.drawable.dice_2,
                R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6 )
        val rollButton: Button = findViewById(R.id.roll_button)
        val decreaseButton: Button = findViewById(R.id.decrease_button)
        val diceImage: ImageView = findViewById(R.id.dice_image)
        rollButton.setOnClickListener{ diceImage.setImageResource(roll()) }
        decreaseButton.text = getString(R.string.decrease_string, maxSides - 1)
        decreaseButton.setOnClickListener{ decreaseSides(decreaseButton) }
    }

    /*
     * Generate random integer between one and maximum number, and return image resource.
     */
    private fun roll(): Int {
        return sideResources[Random.nextInt(minSides..maxSides)]
    }

    /*
     * Decrement the number of sides.
     */
    private fun decreaseSides(decreaseButton: Button) {
        maxSides--
        decreaseButton.visibility = if(maxSides == 1) GONE else VISIBLE
        decreaseButton.text = getString(R.string.decrease_string, maxSides - 1)
    }
}