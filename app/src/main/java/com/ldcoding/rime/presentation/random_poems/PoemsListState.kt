package com.ldcoding.rime.presentation.random_poems

import com.ldcoding.rime.domain.model.Poem

data class PoemsListState(
    val isLoading: Boolean = false,
    val poems: List<Poem> = emptyList(),
    val error: String = ""
)
