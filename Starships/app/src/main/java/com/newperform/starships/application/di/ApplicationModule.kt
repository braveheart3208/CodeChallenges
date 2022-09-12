package com.newperform.starships.application.di

import com.newperform.starships.feature_starships.data.remote.StarshipsAPI
import com.newperform.starships.feature_starships.domain.repository.StarshipRepository
import com.newperform.starships.feature_starships.domain.repository.StarshipRepositoryImpl
import com.newperform.starships.feature_starships.domain.usecase.GetStarshipsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Provides
    @Singleton
    fun providesGetStarshipsUseCase(starshipRepository: StarshipRepository) = GetStarshipsUseCase(starshipRepository)

    @Provides
    @Singleton
    fun providesStarshipRepository(api : StarshipsAPI) : StarshipRepository =
        StarshipRepositoryImpl(api)

    @Provides
    @Singleton
    fun providesStarshipAPI() : StarshipsAPI =
        Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build())
            .baseUrl(StarshipsAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StarshipsAPI::class.java)
}