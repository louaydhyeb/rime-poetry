package com.ldcoding.rime.data.remote.dto

import com.ldcoding.rime.domain.model.Poem

data class PoemDto(
    val content: String,
    val poet: PoetDto,
    val title: String,
    val url: String,
)

fun PoemDto.toPoem(): Poem =
    Poem(
        content = content,
        poet = poet.toPoet(),
        title = title,
        url = url
    )