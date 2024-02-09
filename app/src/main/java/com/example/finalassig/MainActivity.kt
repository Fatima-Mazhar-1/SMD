package com.example.finalassig

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Delayed navigation to SecondActivity after 5 seconds (5000 milliseconds)
        Handler().postDelayed({
            val intent = Intent(this, page2::class.java)
            startActivity(intent)
            finish()  // Optional: Finish the current activity if needed
        }, 5000) // 5000 milliseconds = 5 seconds
    }
}
