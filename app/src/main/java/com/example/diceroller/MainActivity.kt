package com.example.diceroller

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import kotlin.random.nextInt

private var minSides = 1
private var maxSides = 6

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val decreaseButton: Button = findViewById(R.id.decrease_button)
        val diceImage: ImageView = findViewById(R.id.dice_image)
        decreaseButton.text = getString(R.string.decrease_string,maxSides - 1)
        decreaseButton.setOnClickListener{decreaseSides(decreaseButton)}
        rollButton.setOnClickListener{ diceImage.setImageResource(roll()) }
    }

    /*
     * Generate random integer between one and maximum number, and return image resource.
     */
    private fun roll(): Int {
        return resources.getIdentifier("dice_"
                .plus(Random.nextInt(minSides..maxSides)),"drawable","com.example.diceroller")
    }

    /*
     * Decrement the number of sides.
     */
    private fun decreaseSides(decreaseButton: Button){
        maxSides--
        decreaseButton.visibility = if(maxSides == 1) GONE else VISIBLE
        decreaseButton.text = getString(R.string.decrease_string,maxSides - 1)
    }
}