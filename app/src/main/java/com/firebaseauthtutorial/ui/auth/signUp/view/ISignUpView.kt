package com.firebaseauthtutorial.ui.auth.signUp.view

interface ISignUpView {

    fun onClear()
    fun onShowProgress()
    fun onHideProgress()
    fun onSignUpSuccess()
    fun onSignUpFailed()
}