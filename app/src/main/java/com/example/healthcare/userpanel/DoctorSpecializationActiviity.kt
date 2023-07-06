package com.example.healthcare.userpanel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.healthcare.R

class DoctorSpecializationActiviity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_specialization_activiity)

        val title = findViewById<TextView>(R.id.specilizationTitle)

        val titleName: String = intent.getStringExtra("specialization").toString()
        title.text = titleName
    }
}