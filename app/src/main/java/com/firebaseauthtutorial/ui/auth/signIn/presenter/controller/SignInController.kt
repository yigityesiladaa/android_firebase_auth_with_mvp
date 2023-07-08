package com.firebaseauthtutorial.ui.auth.signIn.presenter.controller

import com.firebaseauthtutorial.firebase.repositories.FirebaseAuthRepository

object SignInController {
    private var firebaseAuthRepository = FirebaseAuthRepository()

    fun requestSignIn(email: String, password: String, controller: ISignInController){
        firebaseAuthRepository.signIn(email,password).addOnCompleteListener { task->
            if(task.isSuccessful){
                controller.onSuccess("successfully logged in")
            }else{
                controller.onFailed()
            }
        }
    }
}