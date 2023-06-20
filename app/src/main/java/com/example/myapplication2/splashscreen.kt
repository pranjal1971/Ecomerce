package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed

@Suppress("ClassName")
//function for splash screen

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler(Looper.getMainLooper()).postDelayed(1000){
            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }
    }
}