package com.firebaseauthtutorial.ui.auth.signIn.presenter

import com.firebaseauthtutorial.ui.auth.signIn.presenter.controller.ISignInController
import com.firebaseauthtutorial.ui.auth.signIn.presenter.controller.SignInController
import com.firebaseauthtutorial.ui.auth.signIn.view.ISignInView

class SignInPresenter(private var iSignInView: ISignInView): ISignInPresenter {
    override fun clear() {
        iSignInView.onClear()
    }

    override fun showProgress() {
        iSignInView.onShowProgress()
    }

    override fun hideProgress() {
        iSignInView.onHideProgress()
    }

    override fun signInSuccess(){
        iSignInView.onSignInSuccess()
    }

    override fun signInFailed(){
        iSignInView.onSignInFailed()
    }

    override fun signIn(email: String, password: String) {
        showProgress()
        SignInController.requestSignIn(email, password, object: ISignInController{
            override fun onSuccess(successMessage: String) {
                hideProgress()
                signInSuccess()
            }

            override fun onFailed() {
                hideProgress()
                signInFailed()
            }

        })
    }
}