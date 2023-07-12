package com.example.healthcare.adminpanel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.healthcare.R
import com.example.healthcare.adminpanel.adminlabtest.AdminEditLabTestActivity
import com.example.healthcare.adminpanel.edit.AdminActivity
import com.example.healthcare.authentication.LoginActivity

class AdminMainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_main)

        val doctorDetails = findViewById<TextView>(R.id.MainEditDDetails)
        val labDetails = findViewById<TextView>(R.id.MainEditLDetails)
        val logout = findViewById<TextView>(R.id.MainAdminLogout)

        logout.setOnClickListener{
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }

        doctorDetails.setOnClickListener{
            startActivity(Intent(applicationContext, AdminActivity::class.java))

        }

        labDetails.setOnClickListener{
            startActivity(Intent(applicationContext, AdminEditLabTestActivity::class.java))
        }

    }
}