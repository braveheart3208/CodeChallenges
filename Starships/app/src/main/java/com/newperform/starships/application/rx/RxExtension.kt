package com.interpos.centralpos.application.rx

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by toanduong on 22,February,2020
 * INTERPOS Pty Ltd
 * Melbourne, Australia
 */

/***
 * This will act on a Observable<T> and threadSafely it for safe value return to
 * subscribers and return an instance of itself to continue the builder pattern chain
 */
fun <T> Observable<T>.threadSafely(): Observable<T> {
    return subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .cache()
}

/***
 * This will act on a Single<T> and threadSafely it for safe value return to
 * subscribers and return an instance of itself to continue the builder pattern chain
 */
fun <T> Single<T>.threadSafely(): Single<T> {
    return subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .cache()
}

fun <T> Single<T>.threadSafelyIndependent(): Single<T> {
    return subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .cache()
}

fun <T> Single<T>.threadUnsafely(): Single<T> {
    return subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())
        .cache()
}

/***
 * This will act on a Completable and threadSafely it for safe value return to
 * subscribers and return an instance of itself to continue the builder pattern chain
 */
fun Completable.threadSafely(): Completable {
    return subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .cache()
}