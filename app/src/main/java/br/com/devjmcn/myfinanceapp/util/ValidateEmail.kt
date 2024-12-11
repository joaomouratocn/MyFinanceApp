package br.com.devjmcn.myfinanceapp.util

fun isValidEmail(email: String): Boolean {
    val emailPattern = Regex(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,6}$"
    )
    return email.matches(emailPattern)
}