package com.example.finalassig

import android.app.Activity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseManager(private val activity: Activity) {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signIn(email: String, password: String, onSuccess: (FirebaseUser?) -> Unit, onFailure: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    onSuccess(user)
                } else {
                    onFailure(task.exception?.message ?: "Authentication failed.")
                }
            }
    }


}