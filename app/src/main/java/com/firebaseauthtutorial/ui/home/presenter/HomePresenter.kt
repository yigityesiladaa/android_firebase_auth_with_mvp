package com.firebaseauthtutorial.ui.home.presenter

import com.firebaseauthtutorial.ui.home.presenter.controller.HomeController
import com.firebaseauthtutorial.ui.home.presenter.controller.IHomeController
import com.firebaseauthtutorial.ui.home.view.IHomeView

class HomePresenter(private val iHomeView: IHomeView): IHomePresenter {
    override fun showProgress() {
        iHomeView.onShowProgress()
    }

    override fun hideProgress() {
        iHomeView.onHideProgress()
    }

    override fun signedOutSuccess() {
        iHomeView.onSignedOutSuccess()
    }

    override fun signedOutFailed() {
        iHomeView.onSignedOutFailed()
    }

    override fun signOut() {
        showProgress()
        HomeController.requestSignOut(object: IHomeController{
            override fun onSuccess(successMessage: String) {
                hideProgress()
                signedOutSuccess()
            }

            override fun onFailed() {
                hideProgress()
                signedOutFailed()
            }
        })
    }
}