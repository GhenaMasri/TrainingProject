package com.example.trainingproject.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.trainingproject.R
import com.example.trainingproject.ui.theme.TrainingProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }

        },
        title = {
            Text(text = stringResource(id = R.string.android_news))
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            /* To be modified later*/
            //containerColor = MaterialTheme.colorScheme,
            titleContentColor = MaterialTheme.colorScheme.tertiary,
        ),
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Settings, contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }

        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    )
}

@Preview
@Composable
private fun TopNarPreview() {
    TrainingProjectTheme {
        TopBar(modifier = Modifier)
    }
}