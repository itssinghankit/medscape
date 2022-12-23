package com.example.invincibles

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Radapter( val datalist:ArrayList<HospitalDetail>): RecyclerView.Adapter< Radapter.viewHolder>() {

    class viewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name=itemView.findViewById<TextView>(R.id.hospitalname)
        val state= itemView.findViewById<TextView>(R.id.state)
        val city=itemView.findViewById<TextView>(R.id.city)
        val phoneno=itemView.findViewById<TextView>(R.id.phoneno)
        val area=itemView.findViewById<TextView>(R.id.area)
        val email=itemView.findViewById<TextView>(R.id.email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.hospitalecyitem,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.name.text=datalist[position].hospitalname
        holder.state.text=datalist[position].state
        holder.city.text=datalist[position].city
        holder.area.text=datalist[position].area
        holder.phoneno.text=datalist[position].phoneno
        holder.email.text=datalist[position].email
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}