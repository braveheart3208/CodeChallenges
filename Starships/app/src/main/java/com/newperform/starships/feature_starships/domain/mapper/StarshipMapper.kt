package com.newperform.starships.feature_starships.domain.mapper

import com.newperform.starships.feature_starships.data.remote.dto.StarshipDTO
import com.newperform.starships.feature_starships.domain.model.Starship

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
object StarshipMapper {
    fun fromStarshipDTO(starshipDTO: StarshipDTO) =
        Starship(
            cargoCapacity = starshipDTO.cargo_capacity,
            crew = starshipDTO.crew,
            length = starshipDTO.length,
            manufacturer = starshipDTO.manufacturer,
            maxSpeed = starshipDTO.max_atmosphering_speed,
            model = starshipDTO.model,
            name = starshipDTO.name
        )
}