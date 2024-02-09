package com.example.finalassig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class page3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)
    }

    // Add this function to handle button click
    fun onButtonClick(view: View) {
        val intent = Intent(this, page4::class.java)
        view.context.startActivity(intent)
        finish()
    }
}
