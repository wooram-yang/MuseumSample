package com.moreflow.museumsample.repository

import androidx.annotation.WorkerThread
import com.moreflow.museumsample.api.MuseumAPI
import com.moreflow.museumsample.api.MuseumService
import com.skydoves.sandwich.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import timber.log.Timber

class MuseumRepository {
    private val api: MuseumAPI = MuseumService.api

    suspend fun getGallery() = flow {
        api.getGallery()
            .suspendOnSuccess {
                emit(data)
            }
            .suspendOnError {
                Timber.e("getGallery Error! $errorBody")
            }
            .suspendOnException {
                Timber.e("getGallery Exception! $message")
            }
    }.flowOn(Dispatchers.IO)

    suspend fun getImage(page: Int) = flow {
        api.getImage(page = page)
            .suspendOnSuccess {
                Timber.i("getImage: data = $raw")

                emit(data)
            }
            .suspendOnError {
                Timber.e("getImage Error! $errorBody")
            }
            .suspendOnException {
                Timber.e("getImage Exception! $message")
            }
    }.flowOn(Dispatchers.IO)
}