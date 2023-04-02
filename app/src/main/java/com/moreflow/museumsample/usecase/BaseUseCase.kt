package com.moreflow.museumsample.usecase

interface BaseUseCase<Type, in Params> {
    suspend operator fun invoke(params: Params): Type
}