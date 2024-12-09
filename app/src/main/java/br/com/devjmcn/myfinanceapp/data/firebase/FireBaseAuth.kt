package br.com.devjmcn.myfinanceapp.data.firebase

import br.com.devjmcn.myfinanceapp.data.Repository
import br.com.devjmcn.myfinanceapp.util.Response
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class FireBaseAuth : Repository {
    val firebaseAuthInstance by lazy {
        FirebaseAuth.getInstance()
    }

    override suspend fun singIn(email: String, password: String): Flow<Response<FirebaseUser>> {
        return flow {
            try {
                val result =
                    firebaseAuthInstance.signInWithEmailAndPassword(email, password).await()
                emit(Response.Success(result.user!!))

            } catch (e: FirebaseAuthException) {
                emit(Response.Error("Error: ${e.message}"))
            }
        }
    }
}