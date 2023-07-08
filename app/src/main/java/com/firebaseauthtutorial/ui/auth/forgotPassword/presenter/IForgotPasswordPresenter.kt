package com.firebaseauthtutorial.ui.auth.forgotPassword.presenter

interface IForgotPasswordPresenter {
    fun clear()
    fun showProgress()
    fun hideProgress()
    fun resetMailSentSuccess()
    fun resetMailSentFailed()
    fun resetPassword(email: String)
}