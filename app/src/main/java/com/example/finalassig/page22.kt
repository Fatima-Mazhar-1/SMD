package com.example.finalassig

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class page22 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page22)

        val mAuth = FirebaseAuth.getInstance()
        val mDatabase = FirebaseDatabase.getInstance().reference
        val displayNameEditText =findViewById<EditText>(R.id.nameinput)
        val emailEditText = findViewById<EditText>(R.id.emailinput)
        val  contactNumberEditText = findViewById<EditText>(R.id.contactinput)
        val countryEditText = findViewById<EditText>(R.id.countryinput)
        val  cityEditText = findViewById<EditText>(R.id.cityinput)
        val user: FirebaseUser? = mAuth.currentUser
        user?.uid?.let { uid ->
            mDatabase.child("users").child(uid).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val displayName = snapshot.child("name").value.toString()
                    val email = snapshot.child("email").value.toString()
                    val contactNumber = snapshot.child("contactNumber").value.toString()
                    val country = snapshot.child("country").value.toString()
                    val city = snapshot.child("city").value.toString()

                    displayNameEditText.setText(displayName)
                    emailEditText.setText(email)
                    contactNumberEditText.setText(contactNumber)
                    countryEditText.setText(country)
                    cityEditText.setText(city)
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
        }
        val signUpButton = findViewById<View>(R.id.button)
        signUpButton.setOnClickListener {
            updateUserData(it)
        }


    }
    fun updateUserData(view: View) {
        val mAuth = FirebaseAuth.getInstance()
        val mDatabase = FirebaseDatabase.getInstance().reference
        val user: FirebaseUser? = mAuth.currentUser

        val displayNameEditText =findViewById<EditText>(R.id.nameinput).text.toString()
        val emailEditText = findViewById<EditText>(R.id.emailinput).text.toString()
        val  contactNumberEditText = findViewById<EditText>(R.id.contactinput).text.toString()
        val countryEditText = findViewById<EditText>(R.id.countryinput).text.toString()
        val  cityEditText = findViewById<EditText>(R.id.cityinput).text.toString()

        user?.uid?.let { uid ->
            val userData = mapOf(
                "name" to displayNameEditText,
                "email" to emailEditText,
                "contactNumber" to contactNumberEditText,
                "country" to countryEditText,
                "city" to cityEditText
            )
            mDatabase.child("users").child(uid).updateChildren(userData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    // Handle failure
                    Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show()
                }
        }
    }

    fun goTopage21(view: View) {
        val intent = Intent(this,page21::class.java)
        view.context.startActivity(intent)
        finish()
    }
}