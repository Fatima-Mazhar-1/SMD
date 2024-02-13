package com.example.finalassig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class page21 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page21)
    }
    fun bluecard(view: View) {
        val intent = Intent(this, page22::class.java)
        view.context.startActivity(intent)
        finish()
    }
}