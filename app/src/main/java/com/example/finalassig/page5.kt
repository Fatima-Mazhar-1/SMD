package com.example.finalassig

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class page5 : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page5)

        emailEditText = findViewById(R.id.email)
        auth = FirebaseAuth.getInstance()

        val sendButton: Button = findViewById(R.id.imageButton)
        sendButton.setOnClickListener {
            val email = emailEditText.text.toString()
            if (email.isNotEmpty()) {
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, page6::class.java)
                            intent.putExtra("email", email)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Email does not exist", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun back(view: View) {
        val intent = Intent(this, page2::class.java)
        startActivity(intent)
        finish()
    }

    fun goTo2ndActivity(view: View) {
        val intent = Intent(this, page2::class.java)
        startActivity(intent)
        finish()
    }
}