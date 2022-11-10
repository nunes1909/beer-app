package com.gabriel.remote.beer.mapper

import com.gabriel.data.beer.model.BeerData
import com.gabriel.remote.beer.model.BeerRemote
import com.gabriel.remote.ingrediente.mapper.IngredienteRemoteMapper
import com.gabriel.remote.util.base.RemoteMapper

class BeerRemoteMapper : RemoteMapper<BeerRemote, BeerData> {
    private val mapper = IngredienteRemoteMapper()

    override fun mapToData(type: BeerRemote): BeerData {
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

    override fun mapToRemote(type: BeerData): BeerRemote {
        return BeerRemote(
            id = type.id,
            name = type.name,
            tagline = type.tagline,
            firstBrewed = type.firstBrewed,
            description = type.description,
            abv = type.abv,
            ingredients = mapper.mapToRemoteNonNull(type.ingredients!!),
            brewersTips = type.brewersTips
        )
    }
}
