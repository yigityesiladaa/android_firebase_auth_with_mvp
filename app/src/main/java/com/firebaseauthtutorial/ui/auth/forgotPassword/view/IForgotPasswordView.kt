package com.firebaseauthtutorial.ui.auth.forgotPassword.view

interface IForgotPasswordView {
    fun onClear()
    fun onShowProgress()
    fun onHideProgress()
    fun onResetMailSentSuccess()
    fun onResetMailSentFailed()
}