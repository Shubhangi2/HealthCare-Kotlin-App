package com.example.healthcare.adminpanel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare.R
import com.example.healthcare.adminpanel.edit.AdminActivityAdapter
import com.example.healthcare.adminpanel.edit.EditDoctorDetailModel
import com.example.healthcare.adminpanel.edit.EditFindDoctorActivity
import com.example.healthcare.authentication.LoginActivity
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AdminActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var myadapter: AdminActivityAdapter
    private lateinit var list: ArrayList<EditDoctorDetailModel>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val floatingActionButton: FloatingActionButton = findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener{
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference().child("Admin")
        val recyclerView = findViewById<RecyclerView>(R.id.adminRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        list = arrayListOf<EditDoctorDetailModel>()

        database.child("DDetails").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    list.clear()
                    for(details in snapshot.children){
                        val det =details.getValue(EditDoctorDetailModel::class.java)
                        list.add(det!!)
                    }
                    myadapter = AdminActivityAdapter(applicationContext, list)
                    recyclerView.adapter = myadapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        val tv_FD = findViewById<TextView>(R.id.removeDetails)
        tv_FD.setOnClickListener{
                startActivity(Intent(applicationContext, EditFindDoctorActivity::class.java))

        }

    }
}