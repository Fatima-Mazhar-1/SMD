package com.example.finalassig

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
    }
    fun goToThirdActivity(view: View) {
        val intent = Intent(this, page3::class.java)
        startActivity(intent)
    }
}