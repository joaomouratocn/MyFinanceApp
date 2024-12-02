package br.com.devjmcn.myfinanceapp.ui.screens.singIn

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SingInViewModel : ViewModel() {
    private val firebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _isValidEmail = MutableStateFlow(false)
    val isValidEmail = _isValidEmail.asStateFlow()

    private val _showErrorEmailField = MutableStateFlow("")
    val emailErrorMessage = _showErrorEmailField.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _passwordErrorMessage = MutableStateFlow("")
    val passwordErrorMessage = _passwordErrorMessage.asStateFlow()

    private val _goToHome = MutableStateFlow(false)
    val goToHome = _goToHome.asStateFlow()


    fun updateValueEmail(emailValue: String) {
        _isValidEmail.value = isValidEmail(emailValue)
        if (emailErrorMessage.value != "") _showErrorEmailField.value = ""
        _email.value = emailValue
    }

    fun updateValuePassword(passValue: String) {
        if (_passwordErrorMessage.value != "") _passwordErrorMessage.value = ""
        _password.value = passValue
    }

    fun validateFields() {
        val email = _email.value
        val password = _password.value

        if (!isValidEmail.value) {
            _showErrorEmailField.value = "Invalid email"
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {result ->
            _goToHome.value = true
        }.addOnFailureListener {result ->
            _passwordErrorMessage.value = result.message ?: "Undefined error"
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = Regex(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,6}$"
        )
        return email.matches(emailPattern)
    }

}