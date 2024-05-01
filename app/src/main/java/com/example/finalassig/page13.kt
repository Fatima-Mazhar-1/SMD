package com.example.finalassig
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
class page13 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page13)
    }
    fun bookapp(view: View) {
        val intent = Intent(this, page14::class.java)
        view.context.startActivity(intent)
        finish()
    }
}