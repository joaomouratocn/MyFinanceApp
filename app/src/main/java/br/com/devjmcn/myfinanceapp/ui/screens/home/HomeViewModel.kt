package br.com.devjmcn.myfinanceapp.ui.screens.home

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel:ViewModel() {
    private val firebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    private val _goToSingIn = MutableStateFlow(false)
    val goToSingIn = _goToSingIn.asStateFlow()

    fun getCurrentUser() {
        val currentUser = firebaseAuth.currentUser

        if (currentUser == null){
            _goToSingIn.value = true
        }
    }

    fun logout() {
        firebaseAuth.signOut()
    }
}