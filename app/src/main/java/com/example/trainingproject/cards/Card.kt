@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.trainingproject.cards


import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingproject.R
import com.example.trainingproject.ui.theme.TrainingProjectTheme
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import com.example.trainingproject.ui.theme.green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainCard(modifier: Modifier = Modifier) {
    val kws: List<String> = listOf("Compose","Kotlin","Performance")
    Card(
        modifier = modifier
            .width(360.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Android Logo",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Title",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleLarge.copy(fontFamily = FontFamily.Serif)
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_bookmark),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
            Text(text = "Mar 12,2024", fontSize = 10.sp,)
            Text(
                text = "here would be the content and a brief description about the article",
                fontSize = 14.sp, lineHeight = 1.em, modifier = Modifier.padding(vertical = 6.dp),
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = FontFamily.Serif)
            )
            KeywordsList(keywords = kws)

        }
    }

}

@Composable
fun KeywordLabel(keyword: String,modifier: Modifier = Modifier){
    Box(modifier = modifier
        .background(color = green, shape = CircleShape)) {
        Text(text = keyword, modifier =Modifier.padding(3.dp),
            fontSize = 10.sp, fontFamily = FontFamily.Serif)

    }

}
@Composable
fun KeywordsList(modifier: Modifier = Modifier, keywords: List<String>){
    LazyRow(modifier = modifier,
        contentPadding = PaddingValues(vertical = 3.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),) {
        items(keywords){
            keyword -> KeywordLabel(keyword = keyword)
        }
    }
}

@Preview
@Composable
fun KeywordLabelPreview(){
    KeywordLabel("Keyword",modifier = Modifier)
}

@Preview
@Composable
private fun MainCardPreview() {
    TrainingProjectTheme {
        Scaffold() { padding ->
            MainCard(modifier = Modifier.padding(padding))
        }
    }
}

