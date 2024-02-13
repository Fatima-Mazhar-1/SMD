package com.example.finalassig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class page23 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page23)
    }
    fun emmaphilp(view: View) {
        val intent = Intent(this, page24::class.java)
        view.context.startActivity(intent)
        finish()
    }
}