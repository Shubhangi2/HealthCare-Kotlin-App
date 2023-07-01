package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healthcare.authentication.LoginActivity
import com.example.healthcare.authentication.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        auth = FirebaseAuth.getInstance()
        var user: FirebaseUser? = auth.currentUser
        if(user == null){
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        }else{
            startActivity(Intent(applicationContext, RegisterActivity::class.java))

        }
    }
}