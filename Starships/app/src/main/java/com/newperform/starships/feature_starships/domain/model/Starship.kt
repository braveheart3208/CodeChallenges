package com.newperform.starships.feature_starships.domain.model

import com.newperform.starships.feature_starships.data.remote.dto.StarshipDTO

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
data class Starship (
    val cargoCapacity: String,
    val crew: String,
    val length: String,
    val manufacturer: String,
    val maxSpeed: String,
    val model: String,
    val name: String
){

}