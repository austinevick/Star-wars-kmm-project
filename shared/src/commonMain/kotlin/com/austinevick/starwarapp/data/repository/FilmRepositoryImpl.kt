package com.austinevick.starwarapp.data.repository

import com.austinevick.starwarapp.data.model.CharacterModel
import com.austinevick.starwarapp.data.model.StarshipModel
import com.austinevick.starwarapp.data.remote.ApiService
import com.austinevick.starwarapp.domain.repository.FilmRepository

class FilmRepositoryImpl(private val apiService: ApiService) : FilmRepository  {
    override suspend fun getFilms(query: String): CharacterModel {
        return apiService.getFilms(query)
    }

    override suspend fun getStarships(query: String): StarshipModel {
        return apiService.getStarships(query)
    }
}