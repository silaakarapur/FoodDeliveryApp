package com.example.fooddelivery.view

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.example.fooddelivery.databinding.FragmentHomeBinding
import com.example.fooddelivery.databinding.FragmentLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment() {
    private lateinit var googleSignInClient: GoogleSignInClient
    lateinit var binding: FragmentLoginBinding
    private var mAuth: FirebaseAuth? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        mAuth = FirebaseAuth.getInstance()

        binding = FragmentLoginBinding.inflate(inflater, container, false)

        registerAction()
        loginAction()
        signInGoogle()
        return binding.root


    }


    private fun registerAction() {
        binding.kayitol.setOnClickListener {

            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            Navigation.findNavController(it).navigate(action)

        }


    }

    private fun loginAction() {

        binding.apply {
            girisYapButton.setOnClickListener {

                if (emailedittext.text.toString().isNotEmpty() || passwordedittext.text.toString()
                        .isNotEmpty()
                ) {
                    mAuth!!.signInWithEmailAndPassword(
                        emailedittext.text.toString(),
                        passwordedittext.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(requireContext(), "Giriş Başarılı", Toast.LENGTH_LONG)
                                .show()
                            val action =
                                LoginFragmentDirections.actionLoginFragmentToProfileFragment()
                            view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }
                        }

                    }.addOnFailureListener { exception ->
                        Toast.makeText(
                            requireContext(),
                            exception.localizedMessage,
                            Toast.LENGTH_LONG
                        ).show()
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
        }

    }

    private fun signInGoogle() {
        mAuth = Firebase.auth
        val gao = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("1046623811661-tbigtda1mo3u9pg20l8f22hs4g4ac7vk.apps.googleusercontent.com")
            .requestEmail().build()

        googleSignInClient = GoogleSignIn.getClient(requireContext(), gao)
        binding.signingoogle.setOnClickListener {
            signIn()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                Log.d(ContentValues.TAG, "firebaseAuthWithGoogle" + account.id)
                firebaseAuthWithGoogle(account.idToken)
            } catch (e: ApiException) {
                Log.e(ContentValues.TAG, "Google sign in failed")
            }
        }
    }


    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            val action = LoginFragmentDirections.actionLoginFragmentToProfileFragment()
            view?.let { Navigation.findNavController(it).navigate(action) }

        }
    }

    private fun firebaseAuthWithGoogle(idToken: String?) {
        val creidential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth?.signInWithCredential(creidential)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "signInWithCredential:success")
                    val user = mAuth?.currentUser
                    updateUI(user)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "signInWithCredential:failure", task.exception)
                    updateUI(null)
                }
            }

    }

    companion object {
        const val RC_SIGN_IN = 1001
        const val EXTRA_NAME = "EXTRA NAME"
    }


}