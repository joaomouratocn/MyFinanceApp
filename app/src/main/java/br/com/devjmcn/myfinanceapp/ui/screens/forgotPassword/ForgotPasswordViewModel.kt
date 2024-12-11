package br.com.devjmcn.myfinanceapp.ui.screens.forgotPassword

import androidx.lifecycle.ViewModel
import br.com.devjmcn.myfinanceapp.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow

class ForgotPasswordViewModel(private val repository: Repository) : ViewModel() {
    private val _inputEmail = MutableStateFlow("")
    val inputEmail = _inputEmail

    fun updateInputEmail(newString: String) {
        _inputEmail.value = newString
    }
}