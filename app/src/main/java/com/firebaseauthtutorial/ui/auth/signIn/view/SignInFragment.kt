package com.firebaseauthtutorial.ui.auth.signIn.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.firebaseauthtutorial.R
import com.firebaseauthtutorial.common.extensions.showToast
import com.firebaseauthtutorial.databinding.FragmentSignInBinding
import com.firebaseauthtutorial.ui.auth.signIn.presenter.ISignInPresenter
import com.firebaseauthtutorial.ui.auth.signIn.presenter.SignInPresenter

class SignInFragment : Fragment(), ISignInView {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private lateinit var _navController: NavController
    private lateinit var signInPresenter: ISignInPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        registerEvents()
    }

    private fun init(view: View) {
        signInPresenter = SignInPresenter(this)
        _navController = Navigation.findNavController(view)
    }

    private fun registerEvents() {
        binding.btnSignIn.setOnClickListener {
            val email = binding.etMail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            signInPresenter.signIn(email, password)
        }

        binding.btnSignUpText.setOnClickListener {
            _navController.navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.btnForgotPasswordText.setOnClickListener {
            _navController.navigate(R.id.action_signInFragment_to_forgotPasswordFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClear() {
        binding.etMail.setText("")
        binding.etPassword.setText("")
    }

    override fun onShowProgress() {
        binding.pbSignIn.visibility = View.VISIBLE
    }

    override fun onHideProgress() {
        binding.pbSignIn.visibility = View.GONE
    }

    override fun onSignInSuccess() {
        showToast("Successfully Signed In")
        _navController.navigate(R.id.action_signInFragment_to_homeFragment)
    }

    override fun onSignInFailed() {
        showToast("Sign In Failed")
    }


}