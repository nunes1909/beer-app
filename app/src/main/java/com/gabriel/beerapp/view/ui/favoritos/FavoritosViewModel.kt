package com.gabriel.beerapp.view.ui.favoritos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.beerapp.beer.mapper.BeerViewMapper
import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.useCase.DeleteBeerUseCase
import com.gabriel.domain.beer.useCase.GetBeersFavUseCase
import com.gabriel.strategy.resource.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoritosViewModel(
    private val mapper: BeerViewMapper,
    private val getBeersFavUseCase: GetBeersFavUseCase,
    private val deleteBeerUseCase: DeleteBeerUseCase
) : ViewModel() {

    init {
        getFavoritos()
    }

    private val _favoritos =
        MutableStateFlow<ResourceState<List<BeerView>>>(ResourceState.Loading())
    val favoritos: StateFlow<ResourceState<List<BeerView>>> = _favoritos

    fun getFavoritos() = viewModelScope.launch {
        val resourceDomain = getBeersFavUseCase.getBeersFav()
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

    fun delete(beerView: BeerView) = viewModelScope.launch {
        deleteBeerUseCase.deleteBeer(beerView.id!!)
    }
}
