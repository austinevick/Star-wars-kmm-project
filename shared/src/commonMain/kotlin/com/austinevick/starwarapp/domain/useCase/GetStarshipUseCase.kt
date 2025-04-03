package com.austinevick.starwarapp.domain.useCase

import com.austinevick.starwarapp.data.model.StarshipModel
import com.austinevick.starwarapp.domain.repository.FilmRepository

class GetStarshipUseCase(private val filmRepository: FilmRepository) {
    suspend operator fun invoke(query: String): Result<StarshipModel> {
        return try {
            val starships = filmRepository.getStarships(query)
            Result.success(starships)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}