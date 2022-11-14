package com.gabriel.remote.usuario.dataSource

import android.util.Log
import com.gabriel.data.usuario.dataSource.AutenticaUsuarioDataSource
import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.remote.usuario.validate.ValidaUsuarioFirebase
import com.gabriel.strategy.constants.ConstantsUtil.MSG_AUTH_USER_DS
import com.gabriel.strategy.constants.ConstantsUtil.TAG_AUTH_USER_DS
import com.gabriel.strategy.resource.ResourceState
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.suspendCoroutine

class AutenticaUsuarioDataSourceImpl(
    private val firebaseAuth: FirebaseAuth,
    private val validaUser: ValidaUsuarioFirebase
) : AutenticaUsuarioDataSource {
    override suspend fun autenticaUsuario(usuario: UsuarioData): ResourceState<Boolean> {
        return suspendCoroutine { continuation ->
            firebaseAuth.signInWithEmailAndPassword(usuario.email!!, usuario.senha!!)
                .addOnCompleteListener { task ->
                    continuation.resumeWith(
                        Result.success(validaUser.validaTask(task = task, auth = true))
                    )
                }
                .addOnFailureListener { exception ->
                    Log.e(TAG_AUTH_USER_DS, MSG_AUTH_USER_DS, exception)
                    continuation.resumeWith(Result.failure(exception))
                }
        }
    }
}
