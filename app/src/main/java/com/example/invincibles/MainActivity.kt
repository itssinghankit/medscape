package com.example.invincibles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signinup=findViewById<Button>(R.id.signinup)
        signinup.setOnClickListener(){
            val intent =Intent(this,Signinsignup::class.java)
            startActivity(intent)
        }

    }
}