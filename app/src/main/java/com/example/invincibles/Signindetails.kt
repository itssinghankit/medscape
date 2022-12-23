package com.example.invincibles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signindetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signindetails)



        val email=intent.getStringExtra("email").toString()
        val password=intent.getStringExtra("password").toString()

        val hospitalname=findViewById<EditText>(R.id.hospitalname)
        val phoneno=findViewById<EditText>(R.id.phoneno)
        val pincode=findViewById<EditText>(R.id.pincode)
        val state=findViewById<EditText>(R.id.state)
        val city=findViewById<EditText>(R.id.city)
        val area=findViewById<EditText>(R.id.area)
        val dump=findViewById<RadioGroup>(R.id.dump)
        var dumpenabled:String
        val save=findViewById<Button>(R.id.save)
        val signout=findViewById<Button>(R.id.signout)

        dump.setOnCheckedChangeListener{
                RadioGroup,checkedID->
            dumpenabled=findViewById<RadioButton>(checkedID).text.toString()
        }

        /************to get username to access data*********/
        var username=""
        var i:Int=0
        while(email[i]!='@')
        {
            username=username+email[i]
            i++
        }

        val database=FirebaseDatabase.getInstance().getReference("hospitals")
        database.child(username).get().addOnSuccessListener {
            hospitalname.setText(it.child("hospitalname").value.toString())
            phoneno.setText(it.child("phoneno").value.toString())
            pincode.setText(it.child("pincode").value.toString())
            state.setText(it.child("state").value.toString())
            city.setText(it.child("city").value.toString())
            area.setText(it.child("area").value.toString())
            dumpenabled=it.child("dump").value.toString()
            if(dumpenabled=="Yes"){
                dump.check(R.id.yes)
            }
            else{
                dump.check(R.id.no)
            }

            /*******save*******/
            save.setOnClickListener{

                val dataobject=HospitalDetail(hospitalname.text.toString(),email,phoneno.text.toString(),pincode.text.toString(),state.text.toString(),city.text.toString(),area.text.toString(),dumpenabled)

                var username = ""
                var i = 0
                //this detailEmail will give the string before @symbol
                while (email[i] != '@') {
                    username = username + email[i]
                    i++
                }
                database.child(username).setValue(dataobject).addOnCompleteListener {
                    if (it.isSuccessful)
                        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT)
                            .show()
                    else
                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT)
                            .show()
                }
            }

            }

        /************signout*********/
        signout.setOnClickListener{
           val firebaseAuth= FirebaseAuth.getInstance()
            firebaseAuth.signOut()
            val intent = Intent(this,Siginsignuppage::class.java)
            startActivity(intent)
            finish()
        }


        }

    }
