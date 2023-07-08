package com.firebaseauthtutorial.ui.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.firebaseauthtutorial.R
import com.firebaseauthtutorial.common.extensions.showToast
import com.firebaseauthtutorial.databinding.FragmentHomeBinding
import com.firebaseauthtutorial.ui.home.presenter.HomePresenter
import com.firebaseauthtutorial.ui.home.presenter.IHomePresenter

class HomeFragment : Fragment(), IHomeView {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var _navController: NavController
    private lateinit var homePresenter: IHomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        registerEvents()
    }

    private fun init(view: View){
        homePresenter = HomePresenter(this)
        _navController = Navigation.findNavController(view)
    }
    private fun registerEvents(){
        binding.btnSignOut.setOnClickListener {
            homePresenter.signOut()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onShowProgress() {
        binding.pbHome.visibility = View.VISIBLE
    }

    override fun onHideProgress() {
        binding.pbHome.visibility = View.GONE
    }

    override fun onSignedOutSuccess() {
        showToast("Signed Out")
        _navController.navigate(R.id.action_homeFragment_to_signInFragment)
    }

    override fun onSignedOutFailed() {
        showToast("Sign Out Failed!")
    }


}