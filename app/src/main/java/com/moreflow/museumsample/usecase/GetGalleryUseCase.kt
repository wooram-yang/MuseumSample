package com.moreflow.museumsample.usecase

import com.moreflow.museumsample.entity.GalleryResponse
import com.moreflow.museumsample.repository.MuseumRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGalleryUseCase @Inject constructor(
    private val museumRepository: MuseumRepository
) : BaseUseCase<Flow<GalleryResponse>, Unit> {
    override suspend fun invoke(params: Unit): Flow<GalleryResponse> =
        museumRepository.getGallery()
}