package com.example.fooddelivery.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        mAuth = FirebaseAuth.getInstance()
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.apply {
            kayitolbutton.setOnClickListener {
                if (emailedittext.text.toString().isNotEmpty() || passwordedittext.text.toString()
                        .isNotEmpty()
                ) {
                    mAuth!!.createUserWithEmailAndPassword(
                        emailedittext.text.toString(),
                        passwordedittext.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(requireContext(), "Kayit Başarılı", Toast.LENGTH_LONG)
                                .show()
                        }

                    }.addOnFailureListener { exception ->
                        Toast.makeText(
                            requireContext(),
                            exception.localizedMessage,
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                } else if (emailedittext.text.toString()
                        .isEmpty() && passwordedittext.text.toString().isEmpty()
                ) {
                    Toast.makeText(
                        requireContext(),
                        "Please fill in all the blanks...",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

            girisekraniopen.setOnClickListener {
                val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                Navigation.findNavController(it).navigate(action)
            }

        }


        return binding.root

    }


}