package com.example.finalassig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class page8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page8)
    }
    fun cross(view: View) {
        val intent = Intent(this, page9::class.java)
        view.context.startActivity(intent)
        finish()
    }
}