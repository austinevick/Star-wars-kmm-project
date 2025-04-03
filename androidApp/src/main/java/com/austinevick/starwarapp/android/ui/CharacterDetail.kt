package com.austinevick.starwarapp.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.austinevick.starwarapp.data.model.CharacterData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetail(
    navController: NavHostController,
    data: CharacterData? = null
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
    ) {innerPadding ->
        Column(modifier = Modifier.fillMaxSize()
            .padding(innerPadding)) {

            ListItem(
                headlineContent = {
                Text(text = "Gender: ${data?.gender}")
            })
            ListItem(
                headlineContent = {
                    Text(text = "Hair Color: ${data?.hairColor}")
                })
            ListItem(
                headlineContent = {
                    Text(text = "Height: ${data?.height}")
                })
            ListItem(
                headlineContent = {
                    Text(text = "Skin Color: ${data?.skinColor}")
                })

        }
    }

}