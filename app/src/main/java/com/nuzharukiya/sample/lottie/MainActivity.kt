package com.nuzharukiya.sample.lottie

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView

class MainActivity : Activity() {
    var thumb_up: LottieAnimationView? = null
    var thumb_down: LottieAnimationView? = null
    var toggle: LottieAnimationView? = null
    var flag = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        thumb_up = findViewById(R.id.lav_thumbUp)
        thumb_up?.setOnClickListener {
            thumb_down?.progress = 0f
            thumb_down?.pauseAnimation()
            thumb_up?.playAnimation()
            Toast.makeText(this@MainActivity, "Cheers?", Toast.LENGTH_SHORT).show()
            //---- Your code here------
        }
        thumb_down = findViewById(R.id.lav_thumbDown)
        thumb_down?.setOnClickListener {
            thumb_up?.progress = 0f
            thumb_up?.pauseAnimation()
            thumb_down?.playAnimation()
            Toast.makeText(this@MainActivity, "Boo?", Toast.LENGTH_SHORT).show()
            //---- Your code here------
        }
        toggle = findViewById(R.id.lav_toggle)
        toggle?.setOnClickListener {
            changeState()
        }
    }

    private fun changeState() {
        flag = if (flag == 0) {
            toggle?.setMinAndMaxProgress(
                0f,
                0.43f
            ) //Here, calculation is done on the basis of start and stop frame divided by the total number of frames
            toggle?.playAnimation()
            1
            //---- Your code here------
        } else {
            toggle?.setMinAndMaxProgress(0.5f, 1f)
            toggle?.playAnimation()
            0
            //---- Your code here------
        }
    }
}