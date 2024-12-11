package br.com.devjmcn.myfinanceapp.data

import br.com.devjmcn.myfinanceapp.util.ResponseModel
import com.google.firebase.auth.FirebaseUser

interface Repository {
    suspend fun getCurrentUser(): ResponseModel<FirebaseUser?>

    suspend fun singIn(email: String, password: String): ResponseModel<FirebaseUser>
}