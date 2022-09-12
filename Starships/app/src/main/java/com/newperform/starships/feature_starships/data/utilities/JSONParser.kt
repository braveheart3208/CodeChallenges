package com.newperform.starships.feature_starships.data.utilities

import java.lang.reflect.Type

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
interface JSONParser {
    fun <T> fromJSON(json : String, convertType : Type) : T?

    fun <T> toJSON(convertingObject : T, convertingType : Type) : String? // Maybe leads to null
}