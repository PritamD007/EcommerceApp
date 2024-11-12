package com.example.ecommerceappfinal.fragments.loginRegister

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.ecommerceappfinal.R
import com.example.ecommerceappfinal.data.User
import com.example.ecommerceappfinal.databinding.FragmentRegisterBinding
import com.example.ecommerceappfinal.util.Registervalidation
import com.example.ecommerceappfinal.util.Resource
import com.example.ecommerceappfinal.viewmodwel.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


private val TAG = "RegisterFragment"
@AndroidEntryPoint
class RegisterFragment: Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth : FirebaseAuth
    private val viewModel by viewModels<RegisterViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater)
        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    binding.tvAlreadyHaveAnAccount.setOnClickListener{
        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }
        binding.apply {
            btnRegister.setOnClickListener {

                val user = User(
                    edNameRegister.text.toString(),
                    edEmailRegister.text.toString().trim()
                )
                val password = edPasswordRegister.text.toString()
                viewModel.createAccountWithEmailAndPassword(user, password)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.register.collect {
                when (it) {
                    is Resource.Loading -> {
                        binding.btnRegister
                    }

                    is Resource.Error -> {
                        Log.e(TAG, it.message.toString())
                    }

                    is Resource.Success -> {
                        Log.d("test", it.data.toString())
                    }

                    else -> Unit
                }
            }


        }

        lifecycleScope.launchWhenStarted {
            viewModel.validation.collect { validation ->
                if (validation.email is Registervalidation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.edEmailRegister.apply {
                            requestFocus()
                            error = validation.email.message
                        }
                    }
                }
                if (validation.password is Registervalidation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.edPasswordRegister.apply {
                            requestFocus()
                            error = validation.password.message

                        }
                    }
                }
            }
        }
    }
}