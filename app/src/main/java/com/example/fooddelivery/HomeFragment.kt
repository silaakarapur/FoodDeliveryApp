package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.ActivityMainBinding
import com.example.fooddelivery.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.bottomnavigation.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.home -> {

                    childFragmentManager.primaryNavigationFragment?.findNavController()
                        ?.navigate(R.id.mainFragment)

                }
                R.id.message -> {


                }
                R.id.profile -> {
                    val deger = 1
                    if (deger == 1) {
                        childFragmentManager.primaryNavigationFragment?.findNavController()
                            ?.navigate(R.id.loginFragment)
                    } else {
                        childFragmentManager.primaryNavigationFragment?.findNavController()
                            ?.navigate(R.id.profileFragment)
                    }


                }

            }
        }
        return view

    }


}