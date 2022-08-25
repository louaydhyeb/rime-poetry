package com.ldcoding.rime.domain.repository

import com.ldcoding.rime.data.remote.dto.PoemDto

interface PoemRepository {

    suspend fun getPoems(): List<PoemDto>
}