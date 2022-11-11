package com.gabriel.beerapp.ui.view.detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.gabriel.beerapp.databinding.FragmentDetalhesBinding
import com.gabriel.beerapp.ui.view.adapters.BeersAdapter
import com.gabriel.beerapp.util.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetalhesFragment : BaseFragment<FragmentDetalhesBinding, DetalhesViewModel>() {

    override val viewModel: DetalhesViewModel by viewModel()
    private val adapter by lazy { BeersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecycler()
    }

    private fun configuraRecycler() = with(binding) {
        rvDetalhesSemelhantes.adapter = adapter
        rvDetalhesSemelhantes.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetalhesBinding =
        FragmentDetalhesBinding.inflate(layoutInflater, container, false)
}
