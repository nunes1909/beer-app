package com.gabriel.remote.beer.dataSource

import com.gabriel.data.beer.dataSource.SaveBeerRemoteDataSource
import com.gabriel.data.beer.model.BeerData
import com.gabriel.remote.beer.mapper.BeerRemoteMapper
import com.gabriel.remote.beer.model.BeerDocumento
import com.gabriel.strategy.constants.ConstantsUtil.COLECAO_FAVORITOS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SaveBeerRemoteDataSourceImpl(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth,
    private val mapper: BeerRemoteMapper
) : SaveBeerRemoteDataSource {
    override suspend fun saveBeer(beer: BeerData) {
        val beerRemote = mapper.mapToRemote(beer)
        val usuarioId = firebaseAuth.currentUser!!.uid
        firestore.collection(COLECAO_FAVORITOS).add(
            BeerDocumento(
                beerId = beerRemote.id,
                usuarioId = usuarioId
            )
        )
    }
}