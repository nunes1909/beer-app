package com.gabriel.remote.beer.mapper

import com.gabriel.data.beer.model.BeerData
import com.gabriel.remote.beer.model.BeerRemote
import com.gabriel.remote.util.base.RemoteMapper

class BeerRemoteMapper : RemoteMapper<BeerRemote, BeerData> {
    override fun mapToData(type: BeerRemote): BeerData {
        return BeerData(
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

    override fun mapToRemote(type: BeerData): BeerRemote {
        return BeerRemote(
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
