package com.newperform.starships.feature_starships.data.utilities

import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
class GSONParser(private val myGson : Gson) : JSONParser {
    override fun <T> fromJSON(json: String, convertType: Type): T? {
        return myGson.fromJson(json, convertType)
    }

    override fun <T> toJSON(convertingObject: T, convertingType: Type): String? {
        return myGson.toJson(convertingObject, convertingType)
    }
}