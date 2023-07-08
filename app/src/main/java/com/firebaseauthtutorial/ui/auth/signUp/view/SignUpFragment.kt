package com.firebaseauthtutorial.ui.auth.signUp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.firebaseauthtutorial.R
import com.firebaseauthtutorial.common.extensions.showToast
import com.firebaseauthtutorial.databinding.FragmentSignUpBinding
import com.firebaseauthtutorial.ui.auth.signUp.presenter.ISignUpPresenter
import com.firebaseauthtutorial.ui.auth.signUp.presenter.SignUpPresenter

class SignUpFragment : Fragment(), ISignUpView {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var _navController: NavController
    private lateinit var signUpPresenter: ISignUpPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        registerEvents()
    }

    private fun init(view: View){
        signUpPresenter = SignUpPresenter(this)
        _navController = Navigation.findNavController(view)
    }
    private fun registerEvents(){
        binding.btnSignUp.setOnClickListener {
            val email = binding.etMail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val verifyPassword = binding.etVerifyPassword.text.toString().trim()
            if(password == verifyPassword){
                signUpPresenter.signUp(email,password)
            }else{
                showToast("passwords mismatch!")
            }
        }
        binding.btnSingInText.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClear() {
        binding.etMail.setText("")
        binding.etPassword.setText("")
        binding.etVerifyPassword.setText("")
    }

    override fun onShowProgress() {
        binding.pbSignUp.visibility = View.VISIBLE
    }

    override fun onHideProgress() {
        binding.pbSignUp.visibility = View.GONE
    }

    override fun onSignUpSuccess() {
        showToast("Successfully Signed Up")
        _navController.navigate(R.id.action_signUpFragment_to_homeFragment)
    }

    override fun onSignUpFailed() {
        showToast("Sign Up Failed")
    }
}