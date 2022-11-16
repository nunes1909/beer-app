package com.gabriel.remote.usuario.dataSource

import android.util.Log
import com.gabriel.data.usuario.dataSource.AutenticaUsuarioDataSource
import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.strategy.constants.ConstantsUtil.MSG_AUTH_USER_DS
import com.gabriel.strategy.constants.ConstantsUtil.TAG_AUTH_USER_DS
import com.gabriel.strategy.resource.ResourceState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import kotlin.coroutines.suspendCoroutine

class AutenticaUsuarioDataSourceImpl(private val firebaseAuth: FirebaseAuth) :
    AutenticaUsuarioDataSource {
    override suspend fun autenticaUsuario(usuario: UsuarioData): ResourceState<Boolean> {
        return suspendCoroutine { continuation ->
            firebaseAuth.signInWithEmailAndPassword(usuario.email!!, usuario.senha!!)
                .addOnSuccessListener {
                    continuation.resumeWith(
                        Result.success(ResourceState.Default(data = true))
                    )
                }
                .addOnFailureListener { exception ->
                    val message = catchErrorAuth(exception)
                    continuation.resumeWith(
                        Result.success(ResourceState.Default(data = false, message = message))
                    )
                    Log.e(TAG_AUTH_USER_DS, MSG_AUTH_USER_DS, exception)
                }
        }
    }

    private fun catchErrorAuth(exception: Exception?): String = when (exception) {
        is FirebaseAuthInvalidUserException,
        is FirebaseAuthInvalidCredentialsException -> "E-mail ou senha incorretos"
        else -> "Erro desconhecido -> ${exception?.message}"
    }
}
