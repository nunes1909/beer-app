package com.gabriel.remote.usuario.dataSource

import com.gabriel.data.usuario.dataSource.AutenticaUsuarioDataSource
import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.remote.usuario.validate.ValidaUsuarioFirebase
import com.gabriel.strategy.resource.ResourceState
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
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
        }
    }
}
