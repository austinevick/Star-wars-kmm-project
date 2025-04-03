package com.austinevick.starwarapp.data.remote

import com.austinevick.starwarapp.data.model.CharacterModel
import com.austinevick.starwarapp.data.model.StarshipModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(val client: HttpClient) {

    suspend fun getFilms(query: String): CharacterModel {
        return client.get("https://swapi.dev/api/people/?search=$query").body<CharacterModel>()
    }

    suspend fun getStarships(query: String): StarshipModel {
        return client.get("https://swapi.dev/api/starships/?search=$query").body<StarshipModel>()
    }

}