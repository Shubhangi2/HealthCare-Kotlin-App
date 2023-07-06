package com.example.healthcare.userpanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.healthcare.MainActivity
import com.example.healthcare.R

class FindDoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_doctor)

        val physician = findViewById<CardView>(R.id.cardFDphysician)
        val dentist = findViewById<CardView>(R.id.cardFDdentist)
        val dietician = findViewById<CardView>(R.id.cardFDdietician)
        val surgeon = findViewById<CardView>(R.id.cardFDsurgeon)
        val cardiologist = findViewById<CardView>(R.id.cardFDcardiologist)
        val exit = findViewById<CardView>(R.id.cardFDback)

        physician.setOnClickListener{
            val intent: Intent = Intent(applicationContext, DoctorSpecializationActiviity::class.java)
            intent.putExtra("specialization", "Family Physician")
            startActivity(intent)
        }

        dentist.setOnClickListener{
            val intent: Intent = Intent(applicationContext, DoctorSpecializationActiviity::class.java)
            intent.putExtra("specialization", "Dentist")
            startActivity(intent)
        }

        dietician.setOnClickListener{
            val intent: Intent = Intent(applicationContext, DoctorSpecializationActiviity::class.java)
            intent.putExtra("specialization", "Dietician")
            startActivity(intent)
        }

        surgeon.setOnClickListener{
            val intent: Intent = Intent(applicationContext, DoctorSpecializationActiviity::class.java)
            intent.putExtra("specialization", "Surgeon")
            startActivity(intent)
        }
        cardiologist.setOnClickListener{
            val intent: Intent = Intent(applicationContext, DoctorSpecializationActiviity::class.java)
            intent.putExtra("specialization", "Cardiologist")
            startActivity(intent)
        }

        exit.setOnClickListener{
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }

    }
}