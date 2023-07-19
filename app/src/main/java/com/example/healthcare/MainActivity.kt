package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.healthcare.authentication.LoginActivity
import com.example.healthcare.authentication.RegisterActivity
import com.example.healthcare.userpanel.FindDoctorActivity
import com.example.healthcare.userpanel.buymedicines.BuyMedicinesActivity
import com.example.healthcare.userpanel.confirmorder.ConfirmUserOrder
import com.example.healthcare.userpanel.labtest.LabTestActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findDoctor = findViewById<CardView>(R.id.cardFindDoctor)
        val exit = findViewById<CardView>(R.id.cardExit)
        val labtest = findViewById<CardView>(R.id.cardLabTest)
        val buyMedicine = findViewById<CardView>(R.id.cardBuyMedicine)
        val orderDetails = findViewById<CardView>(R.id.cardOrderDetails)

        exit.setOnClickListener{
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }

        findDoctor.setOnClickListener{
            startActivity(Intent(applicationContext, FindDoctorActivity::class.java))
        }

        labtest.setOnClickListener{
            startActivity(Intent(applicationContext, LabTestActivity::class.java))
        }

        buyMedicine.setOnClickListener{
            startActivity(Intent(applicationContext, BuyMedicinesActivity::class.java))
        }

        orderDetails.setOnClickListener{
            startActivity(Intent(applicationContext, ConfirmUserOrder::class.java))
        }
    }
}