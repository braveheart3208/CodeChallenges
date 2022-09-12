package com.newperform.starships.feature_starships.data.remote

import com.newperform.starships.feature_starships.data.remote.dto.GetStarshipsResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Alex Toan Duong on 12/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
interface StarshipsAPI {
    //API from https://swapi.dev/api/starships/
    @GET("/api/starships/")
    fun getStarships() : Call<GetStarshipsResponse>

    companion object{
        const val BASE_URL = "https://swapi.dev"
    }
}