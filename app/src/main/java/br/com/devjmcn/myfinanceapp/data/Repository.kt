package br.com.devjmcn.myfinanceapp.data

import br.com.devjmcn.myfinanceapp.util.Response
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun singIn(email: String, password: String): Flow<Response<FirebaseUser>>
}