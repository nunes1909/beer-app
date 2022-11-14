package com.gabriel.beerapp.ui.view.favoritos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabriel.beerapp.databinding.FragmentFavoritosBinding
import com.gabriel.beerapp.ui.view.favoritos.adapter.FavoritosAdapter
import com.gabriel.beerapp.util.base.BaseFragmentIn
import com.gabriel.beerapp.util.extensions.toast
import com.gabriel.strategy.constants.ConstantsUtil
import com.gabriel.strategy.resource.ResourceState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritosFragment : BaseFragmentIn<FragmentFavoritosBinding, FavoritosViewModel>() {

    override val viewModel: FavoritosViewModel by viewModel()
    private val adapter by lazy { FavoritosAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecycler()
        configuraClickAdapter()
        observerFavoritos()
    }

    private fun configuraRecycler() = with(binding) {
        rvFavoritos.adapter = adapter
        rvFavoritos.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observerFavoritos() = lifecycleScope.launch {
        viewModel.favoritos.collect { resource ->
            when (resource) {
                is ResourceState.Success -> {
                    adapter.beers = resource.data!!
                }
                is ResourceState.Error -> {
                    toast("Não foi possível os favoritos.")
                    Log.e(
                        ConstantsUtil.TAG_DETALHES_FRAGMENT,
                        "Error -> ${resource.cod}/${resource.message}"
                    )
                }
                else -> {}
            }
        }
    }

    private fun configuraClickAdapter() {
        adapter.setBeerOnClickListener { beerView ->
            val action = FavoritosFragmentDirections.acaoFavoritosParaDetalhes(beerView)
            controller.navigate(action)
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoritosBinding =
        FragmentFavoritosBinding.inflate(layoutInflater, container, false)
}