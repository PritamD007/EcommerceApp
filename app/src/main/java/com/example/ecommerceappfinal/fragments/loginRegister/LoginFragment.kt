package com.example.ecommerceappfinal.fragments.loginRegister

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.ecommerceappfinal.R
import com.example.ecommerceappfinal.activities.ShoppingActivity
import com.example.ecommerceappfinal.databinding.FragmentLoginBinding
import com.example.ecommerceappfinal.dialouge.setupBottomSheetDialog
import com.example.ecommerceappfinal.util.Resource
import com.example.ecommerceappfinal.viewmodwel.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    private val viewModel by viewModels<LoginViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        return binding.root

    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvAccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
            binding.apply {
                btnLogin.setOnClickListener {
                    val email = edEmailLogin.text.toString().trim()
                    val password = edPasswordLogin.text.toString()
                    viewModel.login(email, password)
                }
            }

        binding.tvforgotPassword.setOnClickListener{
            setupBottomSheetDialog { email ->

                viewModel.resetPassword(email)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.resetPassword.collect{
                when (it) {
                    is Resource.Loading -> {
                    }

                    is Resource.Success -> {
                       Snackbar.make(requireView(), "Reset link is sent to your Email",Snackbar.LENGTH_LONG).show()
                    }

                    is Resource.Error -> {
                        Snackbar.make(requireView(), "Error: ${it.message}",Snackbar.LENGTH_LONG).show()

                    }

                    else -> Unit
                }
            }
        }

            lifecycleScope.launchWhenStarted {
                viewModel.login.collect {
                    when (it) {
                        is Resource.Loading -> {
                            binding.btnLogin
                        }

                        is Resource.Success -> {
                            binding.btnLogin
                            Intent(requireActivity(), ShoppingActivity::class.java).also { intent ->
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                               startActivity(intent)
                            }
//                            Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
//                                .navigate(R.id.action_loginFragment_to_homeFragment)
                        }

                        is Resource.Error -> {
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                            binding.btnLogin
                        }

                        else -> Unit
                    }
                }
            }

        }
    }