package com.firebaseauthtutorial.ui.auth.signIn.presenter

interface ISignInPresenter {

    fun clear()
    fun showProgress()
    fun hideProgress()
    fun signInSuccess()
    fun signInFailed()
    fun signIn(email: String, password: String)

}