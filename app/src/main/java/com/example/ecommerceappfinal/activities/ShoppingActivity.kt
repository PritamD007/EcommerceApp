package com.example.ecommerceappfinal.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ecommerceappfinal.R
import com.example.ecommerceappfinal.databinding.ActivityShoppingBinding

class ShoppingActivity: AppCompatActivity() {

  val binding by lazy {
      ActivityShoppingBinding.inflate(layoutInflater)
  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = findNavController(R.id.shoppingHostFragment)
        binding.bottomNavigation.setupWithNavController(navController)
    }
}