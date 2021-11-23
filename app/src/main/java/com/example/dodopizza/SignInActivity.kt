package com.example.dodopizza

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email = findViewById(R.id.sign_email)
        password = findViewById(R.id.sign_password)
    }

    fun regisr(view: android.view.View) {
        startActivity(Intent(this,SignUpActivity::class.java))
    }

    fun sign(view: android.view.View) {
        if (email.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.text).matches() && password.text.isNotEmpty()) {
            Toast.makeText(this,"Успешно",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity::class.java))
        }
        else {
            Toast.makeText(this,"Не удолось",Toast.LENGTH_SHORT).show()
        }
    }
}