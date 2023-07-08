package com.firebaseauthtutorial.ui.auth.forgotPassword.presenter

import com.firebaseauthtutorial.ui.auth.forgotPassword.presenter.controller.ForgotPasswordController
import com.firebaseauthtutorial.ui.auth.forgotPassword.presenter.controller.IForgotPasswordController
import com.firebaseauthtutorial.ui.auth.forgotPassword.view.IForgotPasswordView

class ForgotPasswordPresenter(private val iForgotPasswordView: IForgotPasswordView): IForgotPasswordPresenter {
    override fun clear() {
        iForgotPasswordView.onClear()
    }

    override fun showProgress() {
        iForgotPasswordView.onShowProgress()
    }

    override fun hideProgress() {
        iForgotPasswordView.onHideProgress()
    }

    override fun resetMailSentSuccess() {
        iForgotPasswordView.onResetMailSentSuccess()
    }

    override fun resetMailSentFailed() {
        iForgotPasswordView.onResetMailSentFailed()
    }

    override fun resetPassword(email: String) {
        showProgress()
        ForgotPasswordController.requestSentResetMail(email, object: IForgotPasswordController{
            override fun onSuccess(successMessage: String) {
                hideProgress()
                resetMailSentSuccess()
            }

            override fun onFailed() {
                hideProgress()
                resetMailSentFailed()
            }

        })
    }
}