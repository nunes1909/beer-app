package com.gabriel.remote.beer.dataSource

import android.util.Log
import com.gabriel.data.beer.dataSource.SaveBeerRemoteDataSource
import com.gabriel.data.beer.model.BeerData
import com.gabriel.remote.beer.mapper.BeerRemoteMapper
import com.gabriel.strategy.constants.ConstantsUtil.BEER_ID
import com.gabriel.strategy.constants.ConstantsUtil.COLECAO_FAVORITOS
import com.gabriel.strategy.constants.ConstantsUtil.MSG_SAVE_BEERS_DS
import com.gabriel.strategy.constants.ConstantsUtil.TAG_SAVE_BEERS_DS
import com.gabriel.strategy.constants.ConstantsUtil.USUARIO_ID
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SaveBeerRemoteDataSourceImpl(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth,
    private val mapper: BeerRemoteMapper
) : SaveBeerRemoteDataSource {
    override suspend fun saveBeer(beer: BeerData) {
        val usuarioId = firebaseAuth.currentUser!!.uid
        val beerRemote = mapper.mapToRemote(beer).apply { this.usuarioId = usuarioId }

        val colecao = firestore.collection(COLECAO_FAVORITOS)

        colecao
            .whereEqualTo(USUARIO_ID, firebaseAuth.currentUser?.uid)
            .whereEqualTo(BEER_ID, beerRemote.id)
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    colecao.add(beerRemote)
                }
            }
            .addOnFailureListener { exception ->
                Log.e(TAG_SAVE_BEERS_DS, MSG_SAVE_BEERS_DS, exception)
            }
    }
}