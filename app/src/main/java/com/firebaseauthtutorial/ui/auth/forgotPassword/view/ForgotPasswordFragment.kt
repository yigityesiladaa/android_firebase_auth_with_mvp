package com.firebaseauthtutorial.ui.auth.forgotPassword.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.firebaseauthtutorial.common.extensions.showToast
import com.firebaseauthtutorial.databinding.FragmentForgotPasswordBinding
import com.firebaseauthtutorial.ui.auth.forgotPassword.presenter.ForgotPasswordPresenter
import com.firebaseauthtutorial.ui.auth.forgotPassword.presenter.IForgotPasswordPresenter

class ForgotPasswordFragment : Fragment(), IForgotPasswordView {

    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!
    private lateinit var forgotPasswordPresenter: IForgotPasswordPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        registerEvents()
    }

    private fun init() {
        forgotPasswordPresenter = ForgotPasswordPresenter(this)
    }

    private fun registerEvents() {
        binding.btnSubmit.setOnClickListener {
            val email = binding.etMail.text.toString().trim()
            forgotPasswordPresenter.resetPassword(email)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClear() {
        binding.etMail.setText("")
    }

    override fun onShowProgress() {
        binding.pbForgotPassword.visibility = View.VISIBLE
    }

    override fun onHideProgress() {
        binding.pbForgotPassword.visibility = View.GONE
    }

    override fun onResetMailSentSuccess() {
        showToast("reset password mail sent")
        findNavController().popBackStack()
    }

    override fun onResetMailSentFailed() {
        showToast("failed!")
    }

}