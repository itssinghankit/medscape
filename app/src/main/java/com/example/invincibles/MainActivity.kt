package com.example.invincibles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            val householdwaste=findViewById<Button>(R.id.householdwaste)
        val hospitalwaste=findViewById<Button>(R.id.hospitalwaste)
        val hospitalregisteration=findViewById<Button>(R.id.hospitalregisteration)
        val viewhospital=findViewById<Button>(R.id.viewhospital)

        hospitalregisteration.setOnClickListener(){
            val intent=Intent(this@MainActivity,Siginsignuppage::class.java)
            startActivity(intent)
        }
        viewhospital.setOnClickListener(){
            val intent=Intent(this@MainActivity,HospitalList::class.java)
            startActivity(intent)
        }

    }
}