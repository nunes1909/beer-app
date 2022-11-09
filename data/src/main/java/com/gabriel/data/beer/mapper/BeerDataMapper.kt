package com.gabriel.data.beer.mapper

import com.gabriel.data.beer.model.BeerData
import com.gabriel.data.ingrediente.mapper.IngredienteDataMapper
import com.gabriel.data.util.base.DataMapper
import com.gabriel.domain.beer.model.Beer

class BeerDataMapper : DataMapper<BeerData, Beer> {
    private val mapper = IngredienteDataMapper()

    override fun mapToDomain(type: BeerData): Beer {
        return Beer(
            id = type.id,
            name = type.name,
            tagline = type.tagline,
            firstBrewed = type.firstBrewed,
            description = type.description,
            abv = type.abv,
            ingredients = mapper.mapToDomainNonNull(type.ingredients!!),
            brewersTips = type.brewersTips
        )
    }

    override fun mapToData(type: Beer): BeerData {
        return BeerData(
            id = type.id,
            name = type.name,
            tagline = type.tagline,
            firstBrewed = type.firstBrewed,
            description = type.description,
            abv = type.abv,
            ingredients = mapper.mapToDataNonNull(type.ingredients!!),
            brewersTips = type.brewersTips
        )
    }
}
