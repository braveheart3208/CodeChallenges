package com.newperform.starships.feature_starships.presentation.model

import com.newperform.starships.feature_starships.domain.model.Starship

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
class StarshipState(
    val starships : List<Starship> = emptyList(),
    val isLoading : Boolean = false
)