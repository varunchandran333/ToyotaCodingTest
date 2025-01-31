package com.training.livecodingtest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.training.livecodingtest.domain.model.UserUIModel

@Composable
fun UserDetails(
    userListItem: UserUIModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            userListItem.avatarUrl,
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier.aspectRatio(16f / 9f)
        )
        Spacer(Modifier.height(10.dp))
        Text(userListItem.displayName, fontWeight = FontWeight.Bold)
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(10.dp))
            Text(userListItem.firstAppearance.trim(), maxLines = 1)
            Spacer(Modifier.height(10.dp))
            Text(userListItem.voiceInfo)
        }
    }
}