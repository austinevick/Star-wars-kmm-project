package com.austinevick.starwarapp.domain.di

import com.austinevick.starwarapp.domain.useCase.GetFilmUseCase
import com.austinevick.starwarapp.domain.useCase.GetStarshipUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetFilmUseCase(get()) }
    factory { GetStarshipUseCase(get()) }
}