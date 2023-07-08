package com.firebaseauthtutorial.ui.auth.signUp.controller

interface ISignUpController {
    fun onSuccess(successMessage: String)
    fun onFailed()
}