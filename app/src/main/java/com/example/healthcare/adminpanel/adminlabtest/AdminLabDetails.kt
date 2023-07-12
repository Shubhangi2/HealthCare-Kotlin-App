package com.example.healthcare.adminpanel.adminlabtest

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.healthcare.R
import org.w3c.dom.Text

class AdminLabDetails : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_lab_details)

        val addBtn = findViewById<TextView>(R.id.AdminLabAddDetails)
        addBtn.setOnClickListener{
            startActivity(Intent(applicationContext, AdminEditLabTestActivity::class.java))

        }
    }
}