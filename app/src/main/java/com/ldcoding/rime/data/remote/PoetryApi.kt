package com.ldcoding.rime.data.remote

import com.ldcoding.rime.data.remote.dto.PoemDto
import retrofit2.http.GET

interface PoetryApi {

    @GET("v1/randompoems")
    suspend fun getRandomPoems(): List<PoemDto>
}