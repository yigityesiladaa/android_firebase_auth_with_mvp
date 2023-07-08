package com.firebaseauthtutorial.ui.auth.signIn.view

interface ISignInView {
    fun onClear()
    fun onShowProgress()
    fun onHideProgress()
    fun onSignInSuccess()
    fun onSignInFailed()
}