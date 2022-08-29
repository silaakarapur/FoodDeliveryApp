package com.example.fooddelivery.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fooddelivery.databinding.FragmentProfileBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        //    auth = FirebaseAuth.getInstance()
        binding.outButton.setOnClickListener {
            Firebase.auth.signOut()
            activity?.onBackPressed()

//            val action = ProfileFragmentDirections.actionProfileFragmentToLoginFragment()
//          Navigation.findNavController(it).navigate(action)

        }
        return binding.root
    }


}