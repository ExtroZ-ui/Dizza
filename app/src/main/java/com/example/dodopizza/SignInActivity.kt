package com.example.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.dodopizza.AdapterVp.Login
import com.example.dodopizza.net.ApiRet
import com.example.dodopizza.net.MyRetrofit
import retrofit2.Call
import retrofit2.Response

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
            val retrofit = MyRetrofit().getRetrofit().create(ApiRet::class.java)
            val hashMap: HashMap<String, String> = HashMap()
            hashMap["email"] = email.text.toString()
            hashMap["password"] = password.text.toString()

            val call: Call<Login> = retrofit.login(hashMap)
            call.enqueue(object: retrofit2.Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.body()?.token != null){
                        Login.userToken = response.body()?.token
                        Toast.makeText(this@SignInActivity,"Успешно",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@SignInActivity, MainActivity::class.java))

                    }
                    else{
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Toast.makeText(this@SignInActivity,"Введите корректные данные",Toast.LENGTH_LONG).show()
                }

            })

        }
        else {
            Toast.makeText(this,"Не удолось",Toast.LENGTH_SHORT).show()
        }
    }
}