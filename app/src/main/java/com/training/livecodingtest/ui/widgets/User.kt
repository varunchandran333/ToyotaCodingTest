package com.training.livecodingtest.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.training.livecodingtest.data.model.UserUIModel

@Composable
fun User(
    userListItem: UserUIModel,
    onSelected: (Int) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(100.dp)
            .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
            .padding(8.dp)
            .clickable {
                onSelected(userListItem.id)
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            userListItem.avatarUrl,
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .weight(1f)
        )
        Column(
            Modifier
                .fillMaxHeight()
                .weight(2f, true),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(userListItem.displayName, fontWeight = FontWeight.Bold)
            Text(userListItem.firstAppearance, maxLines = 1)
            Text(userListItem.voiceInfo, maxLines = 1)
        }
    }
}