package com.example.invincibles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Siginsignuppage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_siginsignuppage)

        val signin=findViewById<Button>(R.id.signin)
        val signup=findViewById<Button>(R.id.signup)

        signin.setOnClickListener() {
            val intent = Intent(this@Siginsignuppage, Signin::class.java)
            startActivity(intent)
        }
        signup.setOnClickListener() {
            val intent = Intent(this@Siginsignuppage, Signinsignup::class.java)
            startActivity(intent)
        }

    }
}