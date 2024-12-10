package br.com.devjmcn.myfinanceapp.data.firebase

import android.util.Log
import br.com.devjmcn.myfinanceapp.data.Repository
import br.com.devjmcn.myfinanceapp.util.ResponseModel
import com.google.firebase.auth.FirebaseAuth
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
            if (result.user != null) {
                ResponseModel.Success(result.user!!)
            } else {
                ResponseModel.Error("USER NOT FOUND")
            }
        } catch (e: Exception) {
            Log.d("ERROR", e.message.toString())
            ResponseModel.Error(e.message.toString())
        }
    }
}