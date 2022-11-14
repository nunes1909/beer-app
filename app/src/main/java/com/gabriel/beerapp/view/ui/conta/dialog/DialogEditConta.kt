package com.gabriel.beerapp.view.ui.conta.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gabriel.beerapp.databinding.DialogEditContaBinding
import com.gabriel.beerapp.usuario.model.UsuarioView
import com.gabriel.beerapp.util.extensions.snack
import com.gabriel.beerapp.util.extensions.toast
import com.gabriel.beerapp.view.ui.conta.ContaViewModel
import com.gabriel.beerapp.view.ui.conta.validaConta.ValidaConta
import com.gabriel.strategy.resource.ResourceState
import org.koin.androidx.viewmodel.ext.android.viewModel

class DialogEditConta : DialogFragment() {

    private val args: DialogEditContaArgs by navArgs()
    private val viewModel: ContaViewModel by viewModel()
    private val controller by lazy { findNavController() }
    private lateinit var binding: DialogEditContaBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setView(createView())
        return builder.create()
    }

    private fun createView(): View {
        binding = DialogEditContaBinding.inflate(layoutInflater)
        configuraComponentes()
        salvaEdicaoPerfil()
        return binding.root
    }

    private fun configuraComponentes() = with(binding) {
        etNomeEdit.setText(args.usuarioView.nome.toString())
        etEmailEdit.setText(args.usuarioView.email.toString())
    }

    private fun salvaEdicaoPerfil() {
        binding.btnSalvarEdicao.setOnClickListener { validaCampos() }
    }

    private fun validaCampos() = with(binding) {
        val resource = ValidaConta().validaCamposFormulario(
            nome = etNomeEdit.text!!.trim().toString(),
            email = etEmailEdit.text!!.trim().toString()
        )

        when (resource) {
            is ResourceState.Success -> {
                salvaProfile()
                val action = DialogEditContaDirections.acaoEditContaParaBeers()
                controller.navigate(action)
            }
            else -> {
                toast(resource.message!!)
            }
        }
    }

    private fun salvaProfile() {
        viewModel.updateProfile(
            UsuarioView(
                nome = binding.etNomeEdit.text!!.trim().toString(),
                email = binding.etEmailEdit.text!!.trim().toString()
            )
        )
    }
}
