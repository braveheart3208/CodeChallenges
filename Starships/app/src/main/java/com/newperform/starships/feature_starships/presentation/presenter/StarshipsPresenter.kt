package com.newperform.starships.feature_starships.presentation.presenter

import com.newperform.starships.feature_starships.domain.model.Starship
import com.newperform.starships.feature_starships.domain.usecase.GetStarshipsUseCase
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
class StarshipsPresenter @Inject constructor(
    private val getStarshipsUseCase: GetStarshipsUseCase
) : BasePresenter {

    private var getStarshipDisposable : Disposable? = null

    private var view : StarshipView? = null

    fun initView(view: StarshipView){
        this.view = view
    }

    override fun onStart() {

    }

    override fun onResume() {
        getStarshipDisposable = getStarshipsUseCase.getStarships()
            .doOnSubscribe {
                view?.showLoading()
            }
            .doOnSuccess {
                view?.hideLoading()
            }
            .doOnError{
                view?.hideLoading()
            }
            .subscribeBy(
                onSuccess = {
                    view?.renderStarships(it)
                },
                onError = {
                    view?.showError(it.message?: "")
                }
            )
    }

    override fun onPause() {
        getStarshipDisposable?.dispose()
    }

    override fun onStop() {
        getStarshipDisposable = null
        view = null
    }

    interface StarshipView{
        fun showError(message : String)
        fun showLoading()
        fun hideLoading()
        fun renderStarships(starships : List<Starship>)
    }
}