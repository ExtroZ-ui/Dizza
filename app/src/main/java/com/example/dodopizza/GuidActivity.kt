package com.example.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.dodopizza.AdapterVp.List
import com.example.dodopizza.AdapterVp.VpAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GuidActivity : AppCompatActivity() {
    lateinit var viewpager:ViewPager2
    lateinit var tab:TabLayout
    lateinit var swip:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guid)
        viewpager = findViewById(R.id.view_pager)
        tab = findViewById(R.id.tab_layout)
        swip = findViewById(R.id.swip)

        viewpager.adapter = VpAdapter(this,List.list)
        TabLayoutMediator(tab,viewpager){_,_->}.attach()

        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {

                //Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()

                when(position){
                    2-> {
                        swip.visibility = View.VISIBLE
                    }
                    else -> {
                        swip.visibility = View.INVISIBLE
                    }
                }

            }
        })
    }

    fun swipBut(view: android.view.View) {
        startActivity(Intent(this@GuidActivity, SignInActivity::class.java))
        finish()
    }

}