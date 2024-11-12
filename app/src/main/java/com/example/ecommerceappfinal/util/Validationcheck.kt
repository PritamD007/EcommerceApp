package com.example.ecommerceappfinal.util

import android.util.Patterns

fun validateEmail(email: String): Registervalidation{
    if (email.isEmpty())
        return Registervalidation.Failed("Email cannot be empty")

    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return Registervalidation.Failed("Wrong email Format")
    return Registervalidation.Success
}

fun validatePassword(password: String): Registervalidation{
    if (password.isEmpty())
        return Registervalidation.Failed("Password cannot be empty")

    if (password.length<6)
        return Registervalidation.Failed("Password should contains 6 Characters")
    return Registervalidation.Success
}


