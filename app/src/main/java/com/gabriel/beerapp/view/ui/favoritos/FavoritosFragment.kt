package com.gabriel.beerapp.view.ui.favoritos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabriel.beerapp.databinding.FragmentFavoritosBinding
import com.gabriel.beerapp.view.ui.favoritos.adapter.FavoritosAdapter
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
        viewModel.getFavoritos()
        configuraRecycler()
        configuraClickAdapter()
        observerFavoritos()
    }

    private fun configuraRecycler() = with(binding) {
        rvFavoritos.adapter = adapter
        rvFavoritos.layoutManager = LinearLayoutManager(requireContext())
        ItemTouchHelper(configuraTouchHelper()).attachToRecyclerView(rvFavoritos)
    }

    private fun configuraTouchHelper(): ItemTouchHelper.SimpleCallback {
        return object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val beerView = adapter.beers[viewHolder.adapterPosition]
                viewModel.delete(beerView).also {
                    toast("${beerView.name} removido.")
                    viewModel.getFavoritos()
                }
            }
        }
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
