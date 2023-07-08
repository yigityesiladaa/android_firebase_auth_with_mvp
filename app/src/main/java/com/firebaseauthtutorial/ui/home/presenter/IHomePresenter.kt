package com.firebaseauthtutorial.ui.home.presenter

interface IHomePresenter {
    fun showProgress()
    fun hideProgress()
    fun signedOutSuccess()
    fun signedOutFailed()
    fun signOut()
}