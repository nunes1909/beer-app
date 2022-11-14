package com.gabriel.beerapp.ui.view.favoritos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.beerapp.beer.mapper.BeerViewMapper
import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.useCase.GetBeersByIdUseCase
import com.gabriel.strategy.resource.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoritosViewModel(
    private val mapper: BeerViewMapper,
    private val getBeersByIdUseCase: GetBeersByIdUseCase,
) : ViewModel() {

    init {
        getFavoritos()
    }

    private val _favoritos =
        MutableStateFlow<ResourceState<List<BeerView>>>(ResourceState.Loading())
    val favoritos: StateFlow<ResourceState<List<BeerView>>> = _favoritos

    private fun getFavoritos() = viewModelScope.launch {
        val resourceDomain = getBeersByIdUseCase.getBeersById()
        _favoritos.value = validateResource(resourceDomain)
    }

    private fun validateResource(resource: ResourceState<List<Beer>>):
            ResourceState<List<BeerView>> {
        if (resource.data != null) {
            val listView = mapper.mapToViewNonNull(resource.data!!)
            return ResourceState.Success(listView)
        }
        return ResourceState.Error(cod = resource.cod, message = resource.message)
    }
}
