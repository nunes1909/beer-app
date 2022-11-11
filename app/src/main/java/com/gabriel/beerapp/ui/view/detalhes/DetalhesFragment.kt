package com.gabriel.beerapp.ui.view.detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import coil.load
import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.beerapp.databinding.FragmentDetalhesBinding
import com.gabriel.beerapp.ui.view.adapters.BeersAdapter
import com.gabriel.beerapp.util.base.BaseFragment
import com.gabriel.beerapp.util.extensions.rand
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetalhesFragment : BaseFragment<FragmentDetalhesBinding, DetalhesViewModel>() {

    override val viewModel: DetalhesViewModel by viewModel()
    private val adapter by lazy { BeersAdapter() }
    private val args: DetalhesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecycler()
        preencheCampos()
    }

    private fun configuraRecycler() = with(binding) {
        rvDetalhesSemelhantes.adapter = adapter
        rvDetalhesSemelhantes.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun preencheCampos() = with(binding) {
        args.beerView.let { beerView ->
            ivDetalhes.load(beerView.imageUrl)
            tvTitleDetalhes.text = beerView.name
            tvTaglineDetalhes.text = beerView.tagline
            tvDescriptionDetalhes.text = beerView.description
            tvTeor.text = beerView.abv.toString()
            tvFabricado.text = beerView.firstBrewed
            tvDicasComidas.text = resolveFraseAtual(beerView.foodPairing)
            tvDicasCervejeiros.text = beerView.brewersTips
        }
    }

    private fun resolveFraseAtual(foodPairing: List<String>?): String {
        return foodPairing?.size?.let { size ->
            val posicao = rand(0, size - 1)
            foodPairing[posicao]
        } ?: ""
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetalhesBinding =
        FragmentDetalhesBinding.inflate(layoutInflater, container, false)
}
