package com.newperform.starships.feature_starships.domain.usecase

import com.interpos.centralpos.application.rx.threadSafely
import com.newperform.starships.feature_starships.domain.model.Starship
import com.newperform.starships.feature_starships.domain.repository.StarshipRepository
import io.reactivex.Single

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
class GetStarshipsUseCase(
    private val starshipRepository: StarshipRepository
) {
    fun getStarships() : Single<List<Starship>> =
        starshipRepository.getStarships()
            .threadSafely()
}