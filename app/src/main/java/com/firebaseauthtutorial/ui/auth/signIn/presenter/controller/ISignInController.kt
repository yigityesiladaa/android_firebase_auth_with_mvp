package com.firebaseauthtutorial.ui.auth.signIn.presenter.controller

interface ISignInController {
    fun onSuccess(successMessage: String)
    fun onFailed()
}