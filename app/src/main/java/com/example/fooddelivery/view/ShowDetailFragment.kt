package com.example.fooddelivery.view

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentShowDetailBinding
import com.example.fooddelivery.databinding.FragmentSplashBinding


class ShowDetailFragment : Fragment() {
    lateinit var binding: FragmentShowDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowDetailBinding.inflate(layoutInflater)


        binding.addToCardButton.setOnClickListener {
            val action =
                ShowDetailFragmentDirections.actionShowDetailFragmentToCardFragment()
            Navigation.findNavController(it).navigate(action)
        }
        return binding.root
    }


}