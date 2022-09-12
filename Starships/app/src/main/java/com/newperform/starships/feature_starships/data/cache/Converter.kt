package com.newperform.starships.feature_starships.data.cache

import com.google.gson.reflect.TypeToken
import com.newperform.starships.feature_starships.data.remote.dto.StarshipDTO
import com.newperform.starships.feature_starships.data.utilities.JSONParser

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
class Converter(private val jsonParser: JSONParser) {
    fun fromStarshipJSON(starshipJSON : String) : StarshipDTO? {
        return jsonParser.fromJSON<StarshipDTO>(starshipJSON, object : TypeToken<StarshipDTO>(){}.type)
    }

    fun toStarshipJSON(starshipDTO: StarshipDTO) : String {
        return jsonParser.toJSON(starshipDTO, object : TypeToken<StarshipDTO>(){}.type) ?: "[]"
    }
}