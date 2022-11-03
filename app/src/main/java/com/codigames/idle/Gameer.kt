package com.codigames.idle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.codigames.idle.databinding.ActivityGameerBinding
import java.util.*

class Gameer : AppCompatActivity() {
    val random = Random()
    private lateinit var bindGams: ActivityGameerBinding
    fun getRandom(min: Float, max: Float): Float {
        require(min < max) { "Invalid range [$min, $max]" }
        return min + random.nextFloat() * (max - min)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindGams = ActivityGameerBinding.inflate(layoutInflater)
        setContentView(bindGams.root)
        val updateHandler = Handler()
        val runnable = Runnable {
            updateDisplay()
        }
        updateHandler.postDelayed(runnable, 5000)
    }

    override fun onStart() {
        super.onStart()
        bindGams.crownIV.setOnClickListener{
            translater()
        }
    }
    private fun translater() {
        val min = 0.0f
        val max = 1.0f
        val randomTwo = getRandom(min, max)
        val animation = bindGams.crownIV.animate()
            .x(randomTwo * (bindGams.llWasp.width-bindGams.crownIV.width))
            .y(randomTwo * (bindGams.llWasp.height-bindGams.crownIV.height))
        animation.duration = 300
        animation.start()

    }
    private fun updateDisplay() {
        bindGams.cardView.visibility = View.INVISIBLE
    }
}