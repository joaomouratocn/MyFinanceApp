package br.com.devjmcn.myfinanceapp.data.firebase

import br.com.devjmcn.myfinanceapp.data.Repository
import br.com.devjmcn.myfinanceapp.util.ResponseModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class FireBaseAuth : Repository {
    val firebaseAuthInstance by lazy {
        FirebaseAuth.getInstance()
    }

    override suspend fun singIn(
        email: String,
        password: String
    ): ResponseModel<FirebaseUser> {
        return try {
            val result = firebaseAuthInstance.signInWithEmailAndPassword(email, password).await()
            ResponseModel.Success(result.user!!)
        } catch (e: FirebaseAuthException) {
            ResponseModel.Error(e.errorCode)
        }
    }
}