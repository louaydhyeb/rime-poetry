package com.ldcoding.rime.domain.model

data class Poem(
    val content: String,
    val poet: Poet,
    val title: String,
    val url: String,
)