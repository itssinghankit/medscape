package com.example.invincibles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Signin : AppCompatActivity() {

    private lateinit var firebaseAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)

        firebaseAuth=FirebaseAuth.getInstance()

        val signin=findViewById<Button>(R.id.signin)
        signin.setOnClickListener(){
            if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                val email = email.text.toString()
                val pass = password.text.toString()



                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, Signindetails::class.java)
                        intent.putExtra("email", email)
                        intent.putExtra("password", pass)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "cant be empty", Toast.LENGTH_SHORT).show()
            }

        }

    }
}