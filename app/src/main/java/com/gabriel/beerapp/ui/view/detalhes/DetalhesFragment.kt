package com.gabriel.beerapp.ui.view.detalhes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import coil.load
import com.gabriel.beerapp.databinding.FragmentDetalhesBinding
import com.gabriel.beerapp.ui.view.beers.adapter.BeersAdapter
import com.gabriel.beerapp.util.base.BaseFragmentIn
import com.gabriel.beerapp.util.extensions.rand
import com.gabriel.beerapp.util.extensions.toast
import com.gabriel.strategy.constants.ConstantsUtil.TAG_DETALHES_FRAGMENT
import com.gabriel.strategy.resource.ResourceState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetalhesFragment : BaseFragmentIn<FragmentDetalhesBinding, DetalhesViewModel>() {

    override val viewModel: DetalhesViewModel by viewModel()
    private val args: DetalhesFragmentArgs by navArgs()
    private val adapter by lazy { BeersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.verifyIfExists(args.beerView.id!!)
        configuraRecycler()
        preencheCampos()
        configuraSave()
        buscaSemelhantes()
        observerSemelhantes()
        configuraClickAdapter()
        observerSwitch()
    }

    private fun configuraRecycler() = with(binding) {
        rvDetalhesSemelhantes.adapter = adapter
        rvDetalhesSemelhantes.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun preencheCampos() = lifecycleScope.launch {
        with(binding) {
            args.beerView.let { beerView ->
                ivDetalhes.load(beerView.imageUrl)
                tvTitleDetalhes.text = beerView.name
                tvTaglineDetalhes.text = beerView.tagline
                tvDescriptionDetalhes.text = beerView.description
                tvTeor.text = "${beerView.abv.toString()} %"
                tvFabricado.text = beerView.firstBrewed
                tvDicasComidas.text = resolveFraseAtual(beerView.foodPairing)
                tvDicasCervejeiros.text = beerView.brewersTips
            }
        }
    }

    private fun resolveFraseAtual(foodPairing: List<String>?) =
        foodPairing?.size?.let { size ->
            val posicao = rand(0, size - 1)
            foodPairing[posicao]
        } ?: ""

    private fun configuraSave() {
        binding.swFavoritar.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.save(args.beerView)
            }
        }
    }

    private fun buscaSemelhantes() {
        viewModel.getAll(args.beerView.name)
    }

    private fun observerSemelhantes() = lifecycleScope.launch {
        viewModel.list.collect { resource ->
            when (resource) {
                is ResourceState.Success -> {
                    adapter.beers = resource.data!!
                }
                is ResourceState.Error -> {
                    toast("Não foi possível as Beers semelhantes.")
                    Log.e(
                        TAG_DETALHES_FRAGMENT,
                        "Error -> ${resource.cod}/${resource.message}"
                    )
                }
                else -> {}
            }
        }
    }

    private fun configuraClickAdapter() {
        adapter.setBeerOnClickListener { beerView ->
            val action = DetalhesFragmentDirections.acaoSemelhantesParaDetalhes(beerView)
            controller.navigate(action)
        }
    }

    private fun observerSwitch() = lifecycleScope.launch {
        viewModel.exists.collect { binding.swFavoritar.isChecked = it }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetalhesBinding =
        FragmentDetalhesBinding.inflate(layoutInflater, container, false)
}
