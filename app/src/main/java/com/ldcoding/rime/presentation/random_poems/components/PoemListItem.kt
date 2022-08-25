package com.ldcoding.rime.presentation.random_poems.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ldcoding.rime.domain.model.Poem

@Composable
fun PoemListItem(
    poem: Poem,
    onItemClick: (Poem) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(poem) }
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = poem.title,
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = (poem.poet.name),
            style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = poem.content,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
