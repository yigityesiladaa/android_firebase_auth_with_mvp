package com.firebaseauthtutorial.ui.home.presenter.controller

import com.firebaseauthtutorial.firebase.repositories.FirebaseAuthRepository

object HomeController {
    private var firebaseAuthRepository = FirebaseAuthRepository()

    fun requestSignOut(controller: IHomeController){
        firebaseAuthRepository.signOut().apply {
            controller.onSuccess("Signed Out")
        }
    }
}