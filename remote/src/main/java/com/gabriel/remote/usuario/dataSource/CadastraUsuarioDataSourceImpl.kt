package com.gabriel.remote.usuario.dataSource

import com.gabriel.data.usuario.dataSource.CadastraUsuarioDataSource
import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.domain.util.resource.ResourceState
import com.gabriel.remote.usuario.validate.ValidaUsuarioFirebase
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException

class CadastraUsuarioDataSourceImpl(
    private val firebaseAuth: FirebaseAuth,
    private val validaUser: ValidaUsuarioFirebase
) : CadastraUsuarioDataSource {
    override suspend fun cadastraUsuario(usuario: UsuarioData): ResourceState<Boolean> {
        return try {
            val task = firebaseAuth
                .createUserWithEmailAndPassword(usuario.email!!, usuario.senha!!)
            validaUser.validaTask(task = task, auth = false)
        } catch (e: IllegalAccessException) {
            ResourceState.Error(data = false, message = "E-mail ou senha inválido.")
        }
    }
}
