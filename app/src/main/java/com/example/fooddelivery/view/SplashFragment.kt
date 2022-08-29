package com.example.fooddelivery.view

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fooddelivery.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        Handler().postDelayed({
            val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment2()
            view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }


        }, 1500)
        return binding.root
    }

}