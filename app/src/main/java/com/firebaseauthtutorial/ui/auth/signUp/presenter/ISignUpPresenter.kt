package com.firebaseauthtutorial.ui.auth.signUp.presenter

interface ISignUpPresenter {
    fun clear()
    fun showProgress()
    fun hideProgress()
    fun signUpSuccess()
    fun signUpFailed()
    fun signUp(email: String, password: String)
}