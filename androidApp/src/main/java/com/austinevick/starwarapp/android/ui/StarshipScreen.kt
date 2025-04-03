package com.austinevick.starwarapp.android.ui

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.austinevick.starwarapp.android.navigation.Routes
import com.austinevick.starwarapp.data.model.CharacterModel
import com.austinevick.starwarapp.data.model.StarshipModel
import com.austinevick.starwarapp.theme.ThemeViewModel
import com.austinevick.starwarapp.ui.MainViewModel
import com.austinevick.starwarapp.ui.UiState
import com.google.gson.Gson
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StarshipScreen(
    navController: NavHostController,
    themeViewModel: ThemeViewModel,
    viewModel: MainViewModel = koinViewModel()
) {

    val uiState = viewModel.starshipUiState.collectAsStateWithLifecycle()
    val searchText = viewModel.searchText.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Starships")
                },
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            SearchField(
                searchText.value,
                viewModel::onStarshipSearch,
                themeViewModel
            )

            when (uiState.value) {
                is UiState.Error -> {
                    val errorMessage = (uiState.value as UiState.Error).message
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize() ) {
                        Text(text = errorMessage,
                            style = TextStyle(textAlign = TextAlign.Center))
                        TextButton(onClick = { viewModel.getStarships() }) {
                            Text(text = "Retry")
                        }
                    }
                }

                UiState.Loading -> {
                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator()
                    }
                }

                is UiState.Success<StarshipModel> -> {
                    val films = (uiState.value as UiState.Success<StarshipModel>).data

                    LazyColumn {
                        items(films.results!!.size) { i ->
                            val data = films.results!![i]
                            ListItem(
                                modifier = Modifier.clickable{
                                    val json = Uri.encode(Gson().toJson(data))
                                    navController.navigate(Routes.StarshipsDetail.route+"/${json}")
                                },
                                headlineContent = {
                                    Text(
                                        text = data?.name ?: "",
                                        fontWeight = FontWeight.SemiBold
                                    )
                                },
                                supportingContent = { Text(text = data?.model ?: "") }
                            )
                        }
                    }

                }
            }
        }
    }

}