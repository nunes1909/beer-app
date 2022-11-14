package com.gabriel.beerapp.view.ui.conta

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gabriel.beerapp.databinding.FragmentContaBinding
import com.gabriel.beerapp.usuario.model.UsuarioView
import com.gabriel.beerapp.util.base.BaseFragmentIn
import com.gabriel.beerapp.util.extensions.toast
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContaFragment : BaseFragmentIn<FragmentContaBinding, ContaViewModel>() {

    override val viewModel: ContaViewModel by viewModel()
    private val firebaseAuth: FirebaseAuth by inject()
    private lateinit var usuarioGlobal: UsuarioView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inicializaUsuarioGlobal()
        observerPerfil()
        goEditConta()
    }

    private fun inicializaUsuarioGlobal() {
        usuarioGlobal = UsuarioView(
            nome = firebaseAuth.currentUser!!.displayName,
            email = firebaseAuth.currentUser!!.email
        )
    }

    private fun observerPerfil() {
        binding.tvNomeConta.text = usuarioGlobal.nome
        binding.tvEmailConta.text = usuarioGlobal.email
    }

    private fun goEditConta() {
        binding.btnEditarCadastroConta.setOnClickListener {
            val action = ContaFragmentDirections.acaoContaParaEditConta(usuarioGlobal)
            controller.navigate(action)
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentContaBinding =
        FragmentContaBinding.inflate(layoutInflater, container, false)
}