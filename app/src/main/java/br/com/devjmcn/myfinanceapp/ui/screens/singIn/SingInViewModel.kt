package br.com.devjmcn.myfinanceapp.ui.screens.singIn

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SingInViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _isValidEmail = MutableStateFlow(false)
    val isValidEmail = _isValidEmail.asStateFlow()

    private val _showErrorEmailField = MutableStateFlow(false)
    val showErrorEmailField = _showErrorEmailField.asStateFlow()

    private val _showSnackBar = MutableStateFlow(false)
    val showSnackBar = _showSnackBar.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()


    fun updateValueEmail(emailValue: String) {
        _isValidEmail.value = isValidEmail(emailValue)
        if(showErrorEmailField.value) _showErrorEmailField.value = false
        _email.value = emailValue
    }

    fun updateValuePassword(passValue: String) {
        _password.value = passValue
    }

    fun validateFields() {
        val password = _password.value

        if (!isValidEmail.value){
            _showErrorEmailField.value = true
            return
        }

        //chamar firebase
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = Regex(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,6}$"
        )
        return email.matches(emailPattern)
    }

}