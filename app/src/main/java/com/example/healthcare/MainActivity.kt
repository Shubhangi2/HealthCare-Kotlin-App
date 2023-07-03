package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.healthcare.authentication.LoginActivity
import com.example.healthcare.authentication.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findDoctor = findViewById<CardView>(R.id.cardFindDoctor)
        val exit = findViewById<CardView>(R.id.cardExit)

        exit.setOnClickListener{
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }

    }
}