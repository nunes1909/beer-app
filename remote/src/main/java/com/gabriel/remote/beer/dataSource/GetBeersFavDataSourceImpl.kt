package com.gabriel.remote.beer.dataSource

import android.util.Log
import com.gabriel.data.beer.dataSource.GetBeersFavDataSource
import com.gabriel.data.beer.model.BeerData
import com.gabriel.remote.beer.mapper.BeerRemoteMapper
import com.gabriel.remote.beer.model.BeerRemote
import com.gabriel.strategy.constants.ConstantsUtil.COLECAO_FAVORITOS
import com.gabriel.strategy.constants.ConstantsUtil.MSG_GET_BEERS_FAV_DS
import com.gabriel.strategy.constants.ConstantsUtil.TAG_GET_BEERS_FAV_DS
import com.gabriel.strategy.constants.ConstantsUtil.USUARIO_ID
import com.gabriel.strategy.resource.ResourceState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.coroutines.suspendCoroutine

class GetBeersFavDataSourceImpl(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth,
    private val mapper: BeerRemoteMapper
) : GetBeersFavDataSource {
    override suspend fun getBeersFav(): ResourceState<List<BeerData>> {
        return suspendCoroutine { continuation ->
            val colecao = firestore.collection(COLECAO_FAVORITOS)
            colecao
                .whereEqualTo(USUARIO_ID, firebaseAuth.currentUser?.uid)
                .get()
                .addOnSuccessListener { documents ->
                    val listRemote = mutableListOf<BeerRemote>()
                    for (i in documents) {
                        i.toObject(BeerRemote::class.java).also { beerRemote ->
                            listRemote.add(beerRemote)
                        }
                    }
                    val listData = mapper.mapToDataNonNull(listRemote)
                    continuation.resumeWith(Result.success(ResourceState.Success(listData)))
                }

            colecao.get().addOnFailureListener { exception ->
                Log.e(TAG_GET_BEERS_FAV_DS, MSG_GET_BEERS_FAV_DS, exception)
            }
        }
    }
}
