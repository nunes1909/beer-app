package com.gabriel.remote.beer.dataSource

import com.gabriel.data.beer.dataSource.GetBeersByIdDataSource
import com.gabriel.data.beer.model.BeerData
import com.gabriel.remote.beer.mapper.BeerRemoteMapper
import com.gabriel.remote.beer.model.BeerRemote
import com.gabriel.strategy.constants.ConstantsUtil.COLECAO_FAVORITOS
import com.gabriel.strategy.resource.ResourceState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.coroutines.suspendCoroutine

class GetBeersByIdDataSourceImpl(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth,
    private val mapper: BeerRemoteMapper
) : GetBeersByIdDataSource {
    override suspend fun getBeersById(): ResourceState<List<BeerData>> {
        return suspendCoroutine { continuation ->

            val colecao = firestore.collection(COLECAO_FAVORITOS)
            colecao
                .whereEqualTo("usuarioId", firebaseAuth.currentUser?.uid)
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
                continuation.resumeWith(Result.failure(exception))
            }
        }
    }
}
