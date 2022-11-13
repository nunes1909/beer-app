package com.gabriel.beerapp.ui.view.detalhes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.beerapp.beer.mapper.BeerViewMapper
import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.useCase.GetAllBeersUseCase
import com.gabriel.domain.beer.useCase.GetBeersByIdUseCase
import com.gabriel.domain.beer.useCase.SaveBeerUseCase
import com.gabriel.strategy.resource.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetalhesViewModel(
    private val mapper: BeerViewMapper,
    private val getAllBeersUseCase: GetAllBeersUseCase,
    private val getBeersByIdUseCase: GetBeersByIdUseCase,
    private val saveBeerUseCase: SaveBeerUseCase
) : ViewModel() {

    private val _list = MutableStateFlow<ResourceState<List<BeerView>>>(ResourceState.Loading())
    val list: StateFlow<ResourceState<List<BeerView>>> = _list

    init {
        viewModelScope.launch {
            getBeersByIdUseCase.getBeersById()
        }
    }

    fun getAll(query: String? = null) = viewModelScope.launch {
        val primeiroNome = resolvePrimeiroNome(query)
        val resourceDomain = getAllBeersUseCase.getAll(primeiroNome)
        _list.value = validateResource(resourceDomain)
    }

    private fun resolvePrimeiroNome(query: String?): String? {
        val result = query?.split(" ")
        return result?.let { it[0] }
    }

    private fun validateResource(resource: ResourceState<List<Beer>>):
            ResourceState<List<BeerView>> {
        if (resource.data != null) {
            val listView = mapper.mapToViewNonNull(resource.data!!)
            return ResourceState.Success(listView)
        }
        return ResourceState.Error(cod = resource.cod, message = resource.message)
    }

    fun save(beerView: BeerView) = viewModelScope.launch {
        val beer = mapper.mapToDomain(beerView)
        saveBeerUseCase.saveBeer(beer)
    }
}
