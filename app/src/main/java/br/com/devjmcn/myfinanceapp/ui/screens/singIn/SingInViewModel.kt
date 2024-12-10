package br.com.devjmcn.myfinanceapp.ui.screens.singIn

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.devjmcn.myfinanceapp.data.Repository
import br.com.devjmcn.myfinanceapp.util.ResponseModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SingInViewModel(val repository: Repository) : ViewModel() {

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

    private val _load = MutableStateFlow(false)
    val load = _load.asStateFlow()


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

        if (_password.value.isEmpty()) {
            _passwordErrorMessage.value = "Email is empty"
            return
        }

        viewModelScope.launch {
            _load.value = true
            val result = repository.singIn(email = email, password = password)
            _load.value = false
            when (result) {
                is ResponseModel.Success -> _goToHome.value = true
                is ResponseModel.Error -> _passwordErrorMessage.value = result.message
            }

        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = Regex(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,6}$"
        )
        return email.matches(emailPattern)
    }

}