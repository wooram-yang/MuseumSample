package com.moreflow.museumsample.usecase

import com.moreflow.museumsample.entity.ImageResponse
import com.moreflow.museumsample.repository.MuseumRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val museumRepository: MuseumRepository
) : BaseUseCase<Flow<ImageResponse>, Int> {
    override suspend fun invoke(params: Int): Flow<ImageResponse> =
        museumRepository.getImage(params)
}