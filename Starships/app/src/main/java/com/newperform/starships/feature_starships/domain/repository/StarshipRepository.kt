package com.newperform.starships.feature_starships.domain.repository

import com.newperform.starships.feature_starships.domain.model.Starship
import io.reactivex.Single

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
interface StarshipRepository {
    fun getStarships() : Single<List<Starship>>
}