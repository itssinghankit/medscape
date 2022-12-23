package com.example.invincibles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class signupdetails : AppCompatActivity() {

    private lateinit var database:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupdetails)

        val signup=findViewById<Button>(R.id.signup)




        /************to upload details and signup***************/
        val email=intent.getStringExtra("email").toString()
        val password=intent.getStringExtra("password").toString()




        signup.setOnClickListener(){

            val hospitalname=findViewById<EditText>(R.id.hospitalname).text.toString()
            val phoneno=findViewById<EditText>(R.id.phoneno).text.toString()
            val pincode=findViewById<EditText>(R.id.pincode).text.toString()
            val state=findViewById<EditText>(R.id.state).text.toString()
            val city=findViewById<EditText>(R.id.city).text.toString()
            val area=findViewById<EditText>(R.id.area).text.toString()
            val dump="No"

            val dataobject=HospitalDetail(hospitalname,email,phoneno,pincode,state,city,area,dump)

            database=FirebaseDatabase.getInstance().getReference("hospitals")

            var username = ""
            var i = 0
            //this detailEmail will give the string before @symbol
            while (email[i] != '@') {
                username = username + email[i]
                i++
            }
            database.child(username).setValue(dataobject).addOnCompleteListener {
                if (it.isSuccessful)
                    Toast.makeText(this, "details uploaded", Toast.LENGTH_SHORT)
                        .show()
                else
                    Toast.makeText(this, "upload failed", Toast.LENGTH_SHORT)
                        .show()
            }
        }







    }
}