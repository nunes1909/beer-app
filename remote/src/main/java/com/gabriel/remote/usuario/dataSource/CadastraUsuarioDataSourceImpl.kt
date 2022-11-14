package com.gabriel.remote.usuario.dataSource

import com.gabriel.data.usuario.dataSource.CadastraUsuarioDataSource
import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.remote.usuario.validate.ValidaUsuarioFirebase
import com.gabriel.strategy.resource.ResourceState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest

class CadastraUsuarioDataSourceImpl(
    private val firebaseAuth: FirebaseAuth,
    private val validaUser: ValidaUsuarioFirebase
) : CadastraUsuarioDataSource {
    override suspend fun cadastraUsuario(usuario: UsuarioData): ResourceState<Boolean> {
        return try {
            val task = firebaseAuth.createUserWithEmailAndPassword(usuario.email!!, usuario.senha!!)
            validaUser.validaTask(task = task, auth = false).also { firebaseAuth.signOut() }
        } catch (e: IllegalAccessException) {
            ResourceState.Default(data = false, message = "E-mail ou senha inválido.")
        }
    }
}
