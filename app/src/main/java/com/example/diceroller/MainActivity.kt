package com.example.diceroller

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import kotlin.random.Random
import kotlin.random.nextInt

const val KEY_MAX_SIDES: String = "max_sides_key";

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
        if (savedInstanceState != null){
            Timber.i("Before restoring maxSides = $maxSides")
            maxSides = savedInstanceState.getInt(KEY_MAX_SIDES)
            Timber.i("After restoring maxSides = $maxSides")
        }
        rollButton.setOnClickListener{
            diceImage.setImageResource(roll())
        }
        decreaseButton.text = getString(R.string.decrease_string, maxSides - 1)
        decreaseButton.setOnClickListener{
            decreaseSides(decreaseButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("Saving maxSides = $maxSides")
        outState.putInt(KEY_MAX_SIDES, maxSides)
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