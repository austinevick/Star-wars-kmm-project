package com.austinevick.starwarapp.domain.useCase

import com.austinevick.starwarapp.data.model.CharacterModel
import com.austinevick.starwarapp.data.model.StarshipModel
import com.austinevick.starwarapp.domain.repository.FilmRepository

class GetFilmUseCase(private val filmRepository: FilmRepository) {

    suspend operator fun invoke(query: String): Result<CharacterModel> {
        return try {
            val films = filmRepository.getFilms(query)
            Result.success(films)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}