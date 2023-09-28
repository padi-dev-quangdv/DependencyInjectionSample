package jetpack.tutorial.dependencyinjectionsample.data.remote

import MovieResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

     fun fetchDataFromRemote(): Flow<MovieResponse>
}