package com.example.finalassig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class page18 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page18)
    }
    fun camclick2(view: View) {
        val intent = Intent(this, page19::class.java)
        view.context.startActivity(intent)
        finish()
    }

}