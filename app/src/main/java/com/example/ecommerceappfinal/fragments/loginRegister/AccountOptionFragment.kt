package com.example.ecommerceappfinal.fragments.loginRegister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ecommerceappfinal.R
import com.example.ecommerceappfinal.databinding.FragmentAccountOptionsBinding

class AccountOptionFragment: Fragment(R.layout.fragment_account_options) {
    private lateinit var binding: FragmentAccountOptionsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAccountOptionsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLoginAccountOptions.setOnClickListener {
            findNavController().navigate(R.id.action_accountOptionFragment_to_loginFragment)
        }
        binding.btnRegisterAccountOptions.setOnClickListener {
            findNavController().navigate(R.id.action_accountOptionFragment_to_registerFragment)


        }

    }


}