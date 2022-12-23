package com.example.invincibles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class HospitalList : AppCompatActivity() {


//private lateinit var listitem:ArrayList<HospitalDetail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_list)

        val recycler=findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        var listitem= ArrayList<HospitalDetail>()

        /******firebase data fetching************/
        val database=FirebaseDatabase.getInstance().getReference("hospitals")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {

                    for (usersnapshot in snapshot.children) {
                        val ld = usersnapshot.getValue(HospitalDetail::class.java)

                        listitem.add(ld!!)

                    }
                    recycler.adapter = Radapter(listitem)


                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
}