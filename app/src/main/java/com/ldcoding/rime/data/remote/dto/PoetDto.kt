package com.ldcoding.rime.data.remote.dto

import com.ldcoding.rime.domain.model.Poet

data class PoetDto(
    val name: String,
    val photo_avatar_url: String,
    val url: String,
)

fun PoetDto.toPoet(): Poet =
    Poet(
        name = name,
        photo_avatar_url = photo_avatar_url,
        url = url
    )
