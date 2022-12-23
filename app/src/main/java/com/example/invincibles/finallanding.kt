package com.example.invincibles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class finallanding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finallanding)

      val a=  intent.getStringExtra("index").toString()
        val index=findViewById<TextView>(R.id.index)
//        index.setText(a)
        println(a)
        var database:DatabaseReference
        database=FirebaseDatabase.getInstance().getReference("hospitals")
        database.orderByChild("a").get().addOnSuccessListener {
            index.setText(it.child("state").value.toString())
        }

    }
}