package com.austinevick.starwarapp.data.di

import com.austinevick.starwarapp.data.remote.ApiService
import com.austinevick.starwarapp.data.remote.KtorClient
import com.austinevick.starwarapp.data.repository.FilmRepositoryImpl
import com.austinevick.starwarapp.domain.repository.FilmRepository
import org.koin.dsl.module

val dataModule = module {
    factory { KtorClient.client }
    factory { ApiService(get()) }
    factory <FilmRepository>{ FilmRepositoryImpl(get()) }
}