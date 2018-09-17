package com.nikitae57.myapplication

import android.graphics.Color
import android.os.AsyncTask
import android.os.Build
import android.os.Build.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val colors = intArrayOf(Color.RED, Color.GREEN, Color.BLUE)
    var currentColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (VERSION.SDK_INT < 16) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        setContentView(R.layout.activity_main)

        thread {
            while (true) {
                runOnUiThread {
                    changeColor()
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                }
                Thread.sleep(3000)
            }
        }
    }

    internal fun changeColor() {
        background.setBackgroundColor(colors[currentColor])
        currentColor = (currentColor + 1) % 3
    }
}
