package com.ldcoding.rime.data.repository

import com.ldcoding.rime.data.remote.PoetryApi
import com.ldcoding.rime.data.remote.dto.PoemDto
import com.ldcoding.rime.domain.repository.PoemRepository
import javax.inject.Inject

class PoemRepositoryImp @Inject constructor(
    private val api: PoetryApi,
) : PoemRepository {

    override suspend fun getPoems(): List<PoemDto> {
        return api.getRandomPoems()
    }
}