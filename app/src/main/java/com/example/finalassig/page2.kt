package com.example.finalassig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.finalassig.page3
import com.example.finalassig.page5
import com.example.finalassig.page7

class page2 : AppCompatActivity() {

    private lateinit var firebaseManager: FirebaseManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        firebaseManager = FirebaseManager(this)
        val signUpButton = findViewById<View>(R.id.login)
        signUpButton.setOnClickListener {
            onButtonClick()
        }
    }

    private fun onButtonClick() {
        val email = findViewById<EditText>(R.id.email).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseManager.signIn(email, password,
            {
                Toast.makeText(this, "Authentication success.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, page7::class.java)
                startActivity(intent)
                finish()
            },
            { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )
    }

    fun goTo3rdActivity(view: View) {
        val intent = Intent(this, page3::class.java)
        startActivity(intent)
        finish()
    }

    fun goTo5thActivity(view: View) {
        val intent = Intent(this, page5::class.java)
        startActivity(intent)
        finish()
    }
}