package com.austinevick.starwarapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StarshipModel(
    @SerialName("results")
    val results: List<StarshipData?>? = null
)

@Serializable
data class StarshipData(
    @SerialName("name")
    val name: String? = null,
    @SerialName("model")
    val model: String? = null,
    @SerialName("manufacturer")
    val manufacturer: String? = null,
    @SerialName("cost_in_credits")
    val costInCredits: String? = null,
    @SerialName("length")
    val length: String? = null,
    @SerialName("crew")
    val crew: String? = null,
    @SerialName("passengers")
    val passengers: String? = null,
    @SerialName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String? = null
)
