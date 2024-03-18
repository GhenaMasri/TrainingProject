@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.trainingproject.cards


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.trainingproject.R
import com.example.trainingproject.ui.theme.TrainingProjectTheme
import com.example.trainingproject.ui.theme.green

data class CardUiModel(
    val title: String,
    val date: String,
    val description: String,
    val keywords: List<String>
) {
    companion object {
        fun preview() = CardUiModel(
            title = "title",
            date = "date",
            description = "description",
            keywords = emptyList()
        )
    }
}


@Composable
fun MainCard(modifier: Modifier = Modifier, uiModel: CardUiModel) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .heightIn(min = 220.dp)
        ) {
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
                    text = uiModel.title,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleLarge.copy(fontFamily = FontFamily.Serif)
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_bookmark),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
            Text(text = uiModel.date, fontSize = 10.sp)
            Text(
                text = uiModel.description,
                fontSize = 14.sp, lineHeight = 1.em, modifier = Modifier.padding(vertical = 6.dp),
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = FontFamily.Serif)
            )
            KeywordsList(keywords = uiModel.keywords)

        }
    }

}

@Composable
fun KeywordLabel(keyword: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = green, shape = CircleShape)
    ) {
        Text(
            text = keyword, modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
            fontSize = 10.sp, fontFamily = FontFamily.Serif
        )

    }

}

@Composable
fun KeywordsList(modifier: Modifier = Modifier, keywords: List<String>) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 3.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        items(keywords) { keyword ->
            KeywordLabel(keyword = keyword)
        }
    }
}

@Preview
@Composable
fun KeywordLabelPreview() {
    KeywordLabel("Keyword", modifier = Modifier)
}

@Preview
@Composable
private fun MainCardPreview() {
    TrainingProjectTheme {
        MainCard(uiModel = CardUiModel.preview())
    }
}

