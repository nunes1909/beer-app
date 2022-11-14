package com.gabriel.beerapp.beer.mapper

import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.beerapp.util.base.ViewMapper
import com.gabriel.domain.beer.model.Beer

class BeerViewMapper : ViewMapper<BeerView, Beer> {
    override fun mapToDomain(type: BeerView): Beer {
        return Beer(
            id = type.id,
            name = type.name,
            tagline = type.tagline,
            firstBrewed = type.firstBrewed,
            description = type.description,
            imageUrl = type.imageUrl,
            abv = type.abv,
            foodPairing = type.foodPairing,
            brewersTips = type.brewersTips,
            usuarioId = type.usuarioId
        )
    }

    override fun mapToView(type: Beer): BeerView {
        return BeerView(
            id = type.id,
            name = type.name,
            tagline = type.tagline,
            firstBrewed = type.firstBrewed,
            description = type.description,
            imageUrl = type.imageUrl,
            abv = type.abv,
            foodPairing = type.foodPairing,
            brewersTips = type.brewersTips,
            usuarioId = type.usuarioId
        )
    }
}
