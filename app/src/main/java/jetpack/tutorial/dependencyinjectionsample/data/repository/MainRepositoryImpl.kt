package jetpack.tutorial.dependencyinjectionsample.data.repository

import MovieResponse
import jetpack.tutorial.dependencyinjectionsample.data.local.LocalDataSource
import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDbModel
import jetpack.tutorial.dependencyinjectionsample.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
): MainRepository {

    override fun fetchDataServer(): Flow<MovieResponse> {
        return remoteDataSource.fetchDataFromRemote()
    }

    override fun getAllMoviesDb(): Flow<List<MovieDbModel>> {
        return localDataSource.getAllMoviesFromDb()
    }

    override suspend fun insertMovieToDb(movieDbModel: MovieDbModel) {
        localDataSource.insertMovieToDb(movieDbModel)
    }

    override suspend fun deleteMovieFromDb(movieDbModel: MovieDbModel) {
        localDataSource.deleteMovieFromDb(movieDbModel)
    }
}