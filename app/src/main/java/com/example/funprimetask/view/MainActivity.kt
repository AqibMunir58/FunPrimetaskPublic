package com.example.funprimetask.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.funprimetask.R

class MainActivity : AppCompatActivity() {


//    lateinit var context: Context
//
//    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        context = this@MainActivity
//        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        mainActivityViewModel.getUser()!!.observe(this, Observer { serviceData ->
//            tvfact.text = "Fact : " +serviceData.fact
//            tvlength.text= "Length : " + serviceData.length
//        })

//        btnClick.setOnClickListener {
////            mainActivityViewModel.getUser()!!.observe(this, Observer { serviceData ->
////                tvfact.text = "Fact : " +serviceData.fact
////                tvlength.text= "Length : " + serviceData.length.toString()
////            })
//
//        }

    }
}
