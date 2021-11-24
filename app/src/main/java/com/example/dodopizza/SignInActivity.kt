package com.example.dodopizza

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.dodopizza.AdapterVp.login
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
            val log = MyRetrofit().getRetrofit()
            val getApi = log.create(ApiRet::class.java)
            var hashMap: HashMap<String, String> = HashMap()
            hashMap.put("email",email.text.toString())
            hashMap.put("password",password.text.toString())

            val log_call: retrofit2.Call<login> = getApi.getAuth(hashMap)
            log_call.enqueue(object : retrofit2.Callback<login>{
                override fun onResponse(call: Call<login>, response: Response<login>) {
                    if (response.isSuccessful){
                        Toast.makeText(this@SignInActivity,"Успешно",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@SignInActivity,MainActivity::class.java))
                    }
                }

                override fun onFailure(call: Call<login>, t: Throwable) {
                    Toast.makeText(this@SignInActivity,t.message,Toast.LENGTH_LONG).show()
                }

            })

        }
        else {
            Toast.makeText(this,"Не удолось",Toast.LENGTH_SHORT).show()
        }
    }
}