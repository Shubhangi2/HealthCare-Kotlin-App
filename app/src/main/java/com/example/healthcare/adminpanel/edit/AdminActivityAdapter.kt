package com.example.healthcare.adminpanel.edit

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare.R
import com.example.healthcare.util.toast
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AdminActivityAdapter(val context: Context, val list: ArrayList<EditDoctorDetailModel>) : RecyclerView.Adapter<AdminActivityAdapter.myViewHolder>() {



    inner class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.ddItemName)
        val contact = itemView.findViewById<TextView>(R.id.ddItemContact)
        val location = itemView.findViewById<TextView>(R.id.ddItemLocation)
        val fee = itemView.findViewById<TextView>(R.id.ddItemFee)
        val specialization = itemView.findViewById<TextView>(R.id.adminEDspecialization)
        val delete = itemView.findViewById<TextView>(R.id.ddItemDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.doctor_detail_item, parent, false))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val model : EditDoctorDetailModel = list.get(position)
        holder.name.text = model.name
        holder.contact.text = model.phone
        holder.fee.text = "Fee: "+ model.fees
        holder.location.text = model.location
        val key: String = model.key.toString()
        holder.delete.setOnClickListener{
            val dbref : DatabaseReference = FirebaseDatabase.getInstance().getReference("Admin")
            dbref.child("DDetails").child(key).removeValue()
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        notifyDataSetChanged()
                        toast(context, "Details deleted successfully")
                    }else{
                        val error: String = task.exception.toString()
                        toast(context, error)
                    }
                }
        }

    }


}