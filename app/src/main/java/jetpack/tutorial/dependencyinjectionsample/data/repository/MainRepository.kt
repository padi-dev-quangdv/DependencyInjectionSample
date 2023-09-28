package jetpack.tutorial.dependencyinjectionsample.data.repository

import MovieResponse
import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDbModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    // Remote data
    fun fetchDataServer(): Flow<MovieResponse>

    // Local data
    fun getAllMoviesDb(): Flow<List<MovieDbModel>>

    suspend fun insertMovieToDb(movieDbModel: MovieDbModel)

    suspend fun deleteMovieFromDb(movieDbModel: MovieDbModel)
}