package com.austinevick.starwarapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.austinevick.starwarapp.data.model.CharacterData
import com.austinevick.starwarapp.data.model.CharacterModel
import com.austinevick.starwarapp.data.model.StarshipModel
import com.austinevick.starwarapp.domain.useCase.GetFilmUseCase
import com.austinevick.starwarapp.domain.useCase.GetStarshipUseCase
import io.ktor.util.logging.Logger
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel(
    private val getStarshipUseCase: GetStarshipUseCase,
    private val getFilmUseCase: GetFilmUseCase
) : ViewModel() {

    private val _characterUiState = MutableStateFlow<UiState<CharacterModel>>(UiState.Loading)
    val characterUiState: StateFlow<UiState<CharacterModel>> = _characterUiState.asStateFlow()

    private val _starshipUiState = MutableStateFlow<UiState<StarshipModel>>(UiState.Loading)
    val starshipUiState: StateFlow<UiState<StarshipModel>> = _starshipUiState.asStateFlow()

    private val query = MutableStateFlow("")
    val searchText = query.asStateFlow()

    init {
        getFilms()
        getStarships()
    }


    @OptIn(FlowPreview::class)
    fun onCharacterSearch(text: String) {
        query.value = text
        viewModelScope.launch {
            query.asStateFlow()
                .debounce(500L)
                .distinctUntilChanged()
                .collect { getFilms() }
        }
    }

    @OptIn(FlowPreview::class)
    fun onStarshipSearch(text: String) {
        query.value = text
        viewModelScope.launch {
            query.asStateFlow()
                .debounce(500L)
                .distinctUntilChanged()
                .collect { getStarships()}
        }
    }


    fun getFilms() {
        viewModelScope.launch {
            val result = getFilmUseCase(query.value)
            if (result.isSuccess) {
                _characterUiState.value = UiState.Success<CharacterModel>(result.getOrThrow())
            } else {
                _characterUiState.value =
                    UiState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
            }
        }
    }

    fun getStarships() {
        viewModelScope.launch {
            val result = getStarshipUseCase(query.value)
            if (result.isSuccess) {
                _starshipUiState.value = UiState.Success<StarshipModel>(result.getOrThrow())
            } else {
                _starshipUiState.value =
                    UiState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
            }
        }
    }

}

sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>
    data class Success<out T>(val data: T) : UiState<T>
    data class Error(val message: String) : UiState<Nothing>
}