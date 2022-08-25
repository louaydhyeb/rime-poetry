package com.ldcoding.rime.domain.usecase.get_random_poems

import com.ldcoding.rime.common.Resource
import com.ldcoding.rime.data.remote.dto.toPoem
import com.ldcoding.rime.domain.model.Poem
import com.ldcoding.rime.domain.repository.PoemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPoemsUseCase @Inject constructor(
    private val repository: PoemRepository,
) {
    operator fun invoke(): Flow<Resource<List<Poem>>> = flow {
        try {
            emit(Resource.Loading())
            val poems = repository.getPoems().map { it.toPoem() }
            emit(Resource.Success(poems))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected eroor occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server, Check connection"))
        }
    }
}