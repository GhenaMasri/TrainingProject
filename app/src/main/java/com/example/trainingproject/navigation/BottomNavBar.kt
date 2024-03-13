package com.example.trainingproject.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.trainingproject.R
import com.example.trainingproject.ui.theme.TrainingProjectTheme

@Composable
fun myBottomNavBar(modifier: Modifier = Modifier) {
    NavigationBar() {
        NavigationBarItem(icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = null)
        }, label = {
            Text(text = "Home")
        }, selected = true, onClick = { /*TODO*/ })

        NavigationBarItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.nav_baseline_bookmarks),
                contentDescription = null
            )
        }, label = {
            Text(text = "Saved")
        }, selected = false, onClick = {})

        NavigationBarItem(icon = {
            Icon(painter = painterResource(id = R.drawable.hashtag), contentDescription = null)
        }, label = {
            Text(text = "Interests")
        }, selected = false, onClick = { /*TODO*/ })
    }
}

@Preview
@Composable
private fun myBottomNavBarPreview() {
    TrainingProjectTheme() {
        myBottomNavBar(modifier = Modifier)
    }
}