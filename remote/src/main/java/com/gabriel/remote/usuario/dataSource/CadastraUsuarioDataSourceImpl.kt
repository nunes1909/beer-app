package com.gabriel.remote.usuario.dataSource

import com.gabriel.data.usuario.dataSource.CadastraUsuarioDataSource
import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.remote.usuario.validate.ValidaUsuarioFirebase
import com.gabriel.strategy.resource.ResourceState
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.suspendCoroutine

class CadastraUsuarioDataSourceImpl(
    private val firebaseAuth: FirebaseAuth,
    private val validaUser: ValidaUsuarioFirebase
) : CadastraUsuarioDataSource {
    override suspend fun cadastraUsuario(usuario: UsuarioData): ResourceState<Boolean> {
        return suspendCoroutine { continuation ->
            firebaseAuth.createUserWithEmailAndPassword(usuario.email!!, usuario.senha!!)
                .addOnCompleteListener { task ->
                    continuation.resumeWith(
                        Result.success(validaUser.validaTask(task = task, auth = false)
                            .also { firebaseAuth.signOut() })
                    )
                }
        }
    }
}
