package com.example.invincibles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Signinsignup : AppCompatActivity() {

 private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val next=findViewById<Button>(R.id.next)
        val email=findViewById<EditText>(R.id.email)
        val password=findViewById<EditText>(R.id.password).text.toString()

        next.setOnClickListener(){
            val emailget=findViewById<EditText>(R.id.email).text.toString()
            val passwordget=findViewById<EditText>(R.id.password).text.toString()

            /********to create a user******/

            auth=FirebaseAuth.getInstance()
            auth.createUserWithEmailAndPassword(emailget,passwordget).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this, "Successful Signup ", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }



            val intent= Intent(this@Signinsignup,signupdetails::class.java)
            intent.putExtra("email",emailget)
            intent.putExtra("password",passwordget)
            startActivity(intent)



        }

    }
}