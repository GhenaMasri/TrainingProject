package com.example.trainingproject.interests

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.trainingproject.ui.theme.TrainingProjectTheme

@Composable
fun InterestsItem(
    modifier: Modifier = Modifier,
    uiModel: InterestsItemUiModel,
) {
    val imageLoader = rememberAsyncImagePainter(model = uiModel.image)
    ListItem(
        modifier = modifier,
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent,
            headlineColor = MaterialTheme.colorScheme.onPrimaryContainer,
            leadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            trailingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        leadingContent = {
            Image(
                painter = imageLoader,
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer),
                modifier = Modifier.size(60.dp),
                contentScale = ContentScale.Crop
            )
        },
        headlineContent = {
            Text(
                text = uiModel.topic,
                style = MaterialTheme.typography.titleLarge
            )
        },
        trailingContent = {
            IconButton(onClick = {}) {
                if (uiModel.followed) Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .background(
                            MaterialTheme.colorScheme.inversePrimary,
                            shape = MaterialTheme.shapes.extraLarge
                        )
                        .size(30.dp)
                )
                else Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }

        },
    )
}

@Preview
@Composable
private fun InterestsItemPreview() {
    TrainingProjectTheme {
        InterestsItem(uiModel = InterestsItemUiModel.preview())
    }
}
