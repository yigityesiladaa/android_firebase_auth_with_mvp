package com.firebaseauthtutorial.firebase.repositories

import android.util.Patterns
import com.firebaseauthtutorial.firebase.services.IFirebaseAuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthRepository : IFirebaseAuthService{
    private val authInstance = getAuthInstance()

    companion object{
        fun getAuthInstance() : FirebaseAuth{
            return FirebaseAuth.getInstance()
        }

        fun getCurrentUserId() : String?{
            return getAuthInstance().uid
        }

    }

    fun isEmailValid(email : String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    override fun signIn(email: String, password: String): Task<AuthResult> {
        return authInstance.signInWithEmailAndPassword(email,password)
    }

    override fun signUp(email: String, password: String): Task<AuthResult> {
        return authInstance.createUserWithEmailAndPassword(email, password)
    }

    override fun signOut() {
        authInstance.signOut()
    }

    override fun resetPassword(email: String) : Task<Void> {
        return authInstance.sendPasswordResetEmail(email)
    }

}