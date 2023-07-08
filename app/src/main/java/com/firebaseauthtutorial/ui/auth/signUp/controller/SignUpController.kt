package com.firebaseauthtutorial.ui.auth.signUp.controller

import com.firebaseauthtutorial.firebase.repositories.FirebaseAuthRepository

object SignUpController {
    private var firebaseAuthRepository = FirebaseAuthRepository()

    fun requestSignUp(email: String, password: String, controller: ISignUpController){
        firebaseAuthRepository.signUp(email,password).addOnCompleteListener { task->
            if(task.isSuccessful){
                controller.onSuccess("successfully signed up")
            }else{
                controller.onFailed()
            }
        }
    }
}