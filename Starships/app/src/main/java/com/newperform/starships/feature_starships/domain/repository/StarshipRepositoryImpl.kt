package com.newperform.starships.feature_starships.domain.repository

import com.newperform.starships.feature_starships.data.remote.StarshipsAPI
import com.newperform.starships.feature_starships.data.remote.dto.GetStarshipsResponse
import com.newperform.starships.feature_starships.domain.mapper.StarshipMapper
import com.newperform.starships.feature_starships.domain.model.Starship
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
class StarshipRepositoryImpl(
    private val api: StarshipsAPI
) : StarshipRepository {

    override fun getStarships(): Single<List<Starship>> =
        Single.create { emitter ->
            val starships = mutableListOf<Starship>()

            try {
                api.getStarships()
                    .enqueue(object : Callback<GetStarshipsResponse>{
                        override fun onResponse(
                            call: Call<GetStarshipsResponse>,
                            response: Response<GetStarshipsResponse>
                        ) {
                            response.body()?.let {
                                it.results.forEach { starship->
                                    starships.add(StarshipMapper.fromStarshipDTO(starship))
                                }
                                emitter.onSuccess(starships)
                                return
                            }
                        }

                        override fun onFailure(call: Call<GetStarshipsResponse>, t: Throwable) {
                            emitter.onError(Throwable(message = t.message ?: ""))
                            return
                        }
                    })

            } catch (exception: Exception) {
                //If error occurs, display according error message
                emitter.onError(Throwable(message = exception.message ?: ""))
                return@create
            }
        }
}