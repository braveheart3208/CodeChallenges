package com.newperform.starships.feature_starships.data.remote.dto

data class GetStarshipsResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<StarshipDTO>
)