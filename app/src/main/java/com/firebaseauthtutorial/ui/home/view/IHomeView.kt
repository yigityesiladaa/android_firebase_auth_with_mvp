package com.firebaseauthtutorial.ui.home.view

interface IHomeView {
    fun onShowProgress()
    fun onHideProgress()
    fun onSignedOutSuccess()
    fun onSignedOutFailed()
}