package com.example.fooddelivery.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var mAuth: FirebaseAuth? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mAuth = FirebaseAuth.getInstance()
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.bottomnavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    childFragmentManager.primaryNavigationFragment?.findNavController()
                        ?.navigate(R.id.mainFragment)
                }
                R.id.message -> {
                }
                R.id.profile -> {
                    if (mAuth?.currentUser != null) {

                        childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.profileFragment)
                        println("User boş değil")
                    }
                    else{

                        childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.loginFragment)

                    }
                }
            }
            true
        }
        return binding.root

    }


}