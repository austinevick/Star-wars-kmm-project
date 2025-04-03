package com.austinevick.starwarapp.domain.repository

import com.austinevick.starwarapp.data.model.CharacterModel
import com.austinevick.starwarapp.data.model.StarshipModel

interface FilmRepository {
    suspend fun getFilms(query: String): CharacterModel
    suspend fun getStarships(query: String): StarshipModel
}