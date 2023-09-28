package jetpack.tutorial.dependencyinjectionsample.data.local

import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDao
import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDbModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
): LocalDataSource {

    override fun getAllMoviesFromDb(): Flow<List<MovieDbModel>> {
        return movieDao.getAllMoviesFromDb()
    }

    override suspend fun insertMovieToDb(movieDbModel: MovieDbModel) {
        movieDao.insertMovieToDb(movieDbModel)
    }

    override suspend fun deleteMovieFromDb(movieDbModel: MovieDbModel) {
        movieDao.deleteMovieFromDb(movieDbModel)
    }
}