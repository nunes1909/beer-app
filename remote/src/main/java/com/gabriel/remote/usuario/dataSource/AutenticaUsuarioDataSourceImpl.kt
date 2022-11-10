package com.gabriel.remote.usuario.dataSource

import com.gabriel.data.usuario.dataSource.AutenticaUsuarioDataSource
import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.domain.util.resource.ResourceState
import com.gabriel.remote.usuario.validate.ValidaUsuarioFirebase
import com.google.firebase.auth.FirebaseAuth

class AutenticaUsuarioDataSourceImpl(
    private val firebaseAuth: FirebaseAuth,
    private val validaUser: ValidaUsuarioFirebase
) : AutenticaUsuarioDataSource {
    override suspend fun autenticaUsuario(usuario: UsuarioData): ResourceState<Boolean> {
        return try {
            val task = firebaseAuth.signInWithEmailAndPassword(usuario.email!!, usuario.senha!!)
            validaUser.validaTask(task = task, auth = true)
        } catch (e: IllegalAccessException) {
            ResourceState.Error(data = false, message = "E-mail ou senha não pode ser vazio.")
        }
    }
}
