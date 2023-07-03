package com.example.healthcare.adminpanel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.healthcare.R
import com.example.healthcare.adminpanel.edit.EditFindDoctorActivity
import com.google.firebase.auth.FirebaseAuth

class AdminActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        auth = FirebaseAuth.getInstance()
        val tv_FD = findViewById<TextView>(R.id.removeDetails)
        tv_FD.setOnClickListener{
                startActivity(Intent(applicationContext, EditFindDoctorActivity::class.java))
                finish()
        }

    }
}