package com.firebaseauthtutorial.ui.auth.signUp.presenter

import com.firebaseauthtutorial.ui.auth.signUp.controller.ISignUpController
import com.firebaseauthtutorial.ui.auth.signUp.controller.SignUpController
import com.firebaseauthtutorial.ui.auth.signUp.view.ISignUpView


class SignUpPresenter(private val iSignUpView: ISignUpView): ISignUpPresenter {
    override fun clear() {
        iSignUpView.onClear()
    }

    override fun showProgress() {
        iSignUpView.onShowProgress()
    }

    override fun hideProgress() {
        iSignUpView.onHideProgress()
    }

    override fun signUpSuccess() {
        iSignUpView.onSignUpSuccess()
    }

    override fun signUpFailed() {
        iSignUpView.onSignUpFailed()
    }

    override fun signUp(email: String, password: String) {
        showProgress()
        SignUpController.requestSignUp(email,password,object: ISignUpController{
            override fun onSuccess(successMessage: String) {
                hideProgress()
                signUpSuccess()
            }

            override fun onFailed() {
                hideProgress()
                signUpFailed()
            }

        })
    }


}