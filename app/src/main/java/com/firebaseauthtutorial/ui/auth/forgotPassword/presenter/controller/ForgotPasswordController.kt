package com.firebaseauthtutorial.ui.auth.forgotPassword.presenter.controller

import com.firebaseauthtutorial.firebase.repositories.FirebaseAuthRepository

object ForgotPasswordController{
    private var firebaseAuthRepository = FirebaseAuthRepository()

    fun requestSentResetMail(email: String, controller: IForgotPasswordController){
        firebaseAuthRepository.resetPassword(email).addOnCompleteListener { task->
            if(task.isSuccessful){
                controller.onSuccess("reset password mail sent successfully")
            }else{
                controller.onFailed()
            }
        }
    }
}