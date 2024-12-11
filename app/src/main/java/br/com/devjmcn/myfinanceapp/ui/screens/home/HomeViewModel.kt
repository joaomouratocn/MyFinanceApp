package br.com.devjmcn.myfinanceapp.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.devjmcn.myfinanceapp.data.Repository
import br.com.devjmcn.myfinanceapp.util.ResponseModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {
    private val _showProgressBar = MutableStateFlow(false)
    val showProgressBar = _showProgressBar

    private val _goToSingIn = MutableStateFlow(false)
    val goToSingIn = _goToSingIn.asStateFlow()

    init {
        viewModelScope.launch {
            _showProgressBar.value = true
            val result = repository.getCurrentUser()
            when (result) {
                is ResponseModel.Success -> {
                    if (result.data == null) {
                        _goToSingIn.value = true
                    }
                }

                is ResponseModel.Error -> {
                    Log.d("ERROR", result.message)
                }
            }
            _showProgressBar.value = false
        }
    }
}