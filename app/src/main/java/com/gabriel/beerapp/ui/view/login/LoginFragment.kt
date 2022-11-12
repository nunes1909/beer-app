package com.gabriel.beerapp.ui.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gabriel.beerapp.databinding.FragmentLoginBinding
import com.gabriel.beerapp.util.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private val controller by lazy { findNavController() }
    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goLogin()
        goCadastrar()
    }

    private fun goLogin() {
        binding.btnLoginLogar.setOnClickListener {

        }
    }

    private fun goCadastrar() {
        binding.btnLoginCadastrar.setOnClickListener {
            val action = LoginFragmentDirections.acaoLoginParaCadastro()
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root
}
