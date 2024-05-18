package com.example.trainingproject.feature.cards

import android.content.res.Configuration
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.trainingproject.R
import com.example.trainingproject.main.theme.TrainingProjectTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun MainCard(
    modifier: Modifier = Modifier,
    uiModel: CardUiModel
) {
    var saved by rememberSaveable {
        mutableStateOf(uiModel.saved)
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .heightIn(min = 220.dp)
        ) {
            AsyncImage(
                model = uiModel.image,
                placeholder = painterResource(id = R.drawable.android_logo),
                error = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android Logo",
                contentScale = ContentScale.Crop,
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
                IconButton(onClick = { saved = !saved }) {
                    if (saved) {
                        Icon(
                            painter = painterResource(id = R.drawable.filled_baseline_bookmark),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_bookmark),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
            Text(text = uiModel.date, fontSize = 10.sp)
            Text(
                text = uiModel.description,
                fontSize = 14.sp, lineHeight = 1.em,
                modifier = Modifier.padding(vertical = 6.dp),
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
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
    ) {
        Text(
            text = keyword,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
            fontSize = 10.sp,
            fontFamily = FontFamily.Serif,
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

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun MainCardPreview() {
    TrainingProjectTheme {
        MainCard(uiModel = CardUiModel.preview())
    }
}

