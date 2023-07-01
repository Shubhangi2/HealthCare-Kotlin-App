package com.example.healthcare.authentication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.healthcare.MainActivity
import com.example.healthcare.R
import com.example.healthcare.util.toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val et_email = findViewById<EditText>(R.id.loginEmailAddress)
        val et_password = findViewById<EditText>(R.id.loginPwd)
        val btn = findViewById<Button>(R.id.loginBtn)
        val new_user = findViewById<TextView>(R.id.new_user)

        new_user.setOnClickListener{
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
            finish()
        }


        btn.setOnClickListener{
            btn.isEnabled = false
            val email: String = et_email.text.toString()
            val password: String = et_password.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                toast(applicationContext, "please fill all the input fields")
                btn.isEnabled = true
            }else{
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener{ task ->
                        if(task.isSuccessful){
                            toast(applicationContext, "Login successful")
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                            finish()
                        }else{
                            toast(applicationContext, "Incorrect email or password")
                            btn.isEnabled = true

                        }
                    }
            }
        }
    }
}