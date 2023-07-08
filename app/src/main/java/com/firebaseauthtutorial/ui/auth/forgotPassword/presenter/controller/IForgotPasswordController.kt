package com.firebaseauthtutorial.ui.auth.forgotPassword.presenter.controller

interface IForgotPasswordController {
    fun onSuccess(successMessage: String)
    fun onFailed()
}