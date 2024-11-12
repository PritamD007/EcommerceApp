package com.example.ecommerceappfinal.util

sealed class Registervalidation(){

    object Success: Registervalidation()
    data class Failed(val message: String): Registervalidation()

}

data class RegisterFieldsState(
    val email: Registervalidation,
    val password: Registervalidation
)