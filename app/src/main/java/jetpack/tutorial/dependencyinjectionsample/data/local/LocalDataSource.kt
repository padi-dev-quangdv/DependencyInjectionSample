package jetpack.tutorial.dependencyinjectionsample.data.local

import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDbModel
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllMoviesFromDb(): Flow<List<MovieDbModel>>

    suspend fun insertMovieToDb(movieDbModel: MovieDbModel)

    suspend fun deleteMovieFromDb(movieDbModel: MovieDbModel)
}