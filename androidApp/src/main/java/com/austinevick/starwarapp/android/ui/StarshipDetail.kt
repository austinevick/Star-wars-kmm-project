package com.austinevick.starwarapp.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.austinevick.starwarapp.data.model.StarshipData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StarshipDetail(
    navController: NavHostController,
    data: StarshipData? = null
) {

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                title = {
                    Text(data?.name ?: "", fontWeight = FontWeight.W600)
                })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            ListItem(

                headlineContent = {
                    Text(text = "Model: ${data?.model}")
                })
            ListItem(
                headlineContent = {
                    Text(text = "Manufacturer: ${data?.manufacturer}")
                })
            ListItem(
                headlineContent = {
                    Text(text = "Crew: ${data?.crew}")
                })
            ListItem(
                headlineContent = {
                    Text(text = "Passengers: ${data?.passengers}")
                })
            ListItem(
                headlineContent = {
                    Text(text = "Cost in Credits: ${data?.costInCredits}")
                })
            ListItem(
                headlineContent = {
                    Text(text = "Max Atmosphering Speed: ${data?.maxAtmospheringSpeed}")
                })

        }
    }

}