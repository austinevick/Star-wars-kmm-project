package com.austinevick.starwarapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("results")
    val results: List<CharacterData?>? = null
)

@Serializable
data class CharacterData(
    @SerialName("name")
    val name: String? = null,
    @SerialName("gender")
    val gender: String? = null,
    @SerialName("hair_color")
    val hairColor: String? = null,
    @SerialName("height")
    val height: String? = null,
    @SerialName("mass")
    val mass: String? = null,
    @SerialName("skin_color")
    val skinColor: String? = null
)