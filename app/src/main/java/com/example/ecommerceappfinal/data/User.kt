package com.example.ecommerceappfinal.data

data class User(
    val name: String,
    val email: String,
){
    constructor():this("","")
}
