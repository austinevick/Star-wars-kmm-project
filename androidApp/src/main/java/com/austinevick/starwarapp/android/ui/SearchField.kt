package com.austinevick.starwarapp.android.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.austinevick.starwarapp.theme.ThemeViewModel
import com.austinevick.starwarapp.ui.MainViewModel

@Composable
fun SearchField(
    searchText: String,
    onValueChange: (String) -> Unit,
    viewModel: ThemeViewModel
) {
    val isDarkMode = viewModel.isDarkMode.value
    TextField(
        value = searchText,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                BorderStroke(1.dp,
                    if (isDarkMode) Color.White.copy(alpha = 0.2f) else
                    Color.Black.copy(alpha = 0.2f)),
                RoundedCornerShape(12.dp)
            ),
        onValueChange = onValueChange,
        placeholder = {
            Text("Search by name", color = Color.Gray.copy(alpha = 0.4f))
        },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences
        ),
        textStyle = TextStyle(
            fontSize = 18.0.sp,
            fontWeight = FontWeight.SemiBold
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor =Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}