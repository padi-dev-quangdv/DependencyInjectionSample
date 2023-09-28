package jetpack.tutorial.dependencyinjectionsample.data.remote

import MovieResponse
import android.util.Log
import jetpack.tutorial.dependencyinjectionsample.data.remote.network.ApiService
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: ApiService,
): RemoteDataSource {

    override fun fetchDataFromRemote(): Flow<MovieResponse> {
        return callbackFlow {
            val apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNjM1NWZmZjVjYzAyZjQ4MGY2Y2VkZjk0YzI3N2IyZSIsInN1YiI6IjY1MTJmZTRhOGUyYmE2MDEwMWEwMGVlYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.nJXuhggPK06eHkVNTGrJcK8joSVlsjlTMROc13LY9C8"
            val response = service.getPopularMovies("en-US", 1, "Bearer $apiKey")

            response.enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if(response.isSuccessful) {
                        val movieResponse = response.body()
                        movieResponse?.let {
                            trySend(movieResponse)
                        }
                    } else {
                        Log.d("Main","error: response failed")
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("Main", "Error: ${t.message}")
                }

            })
            awaitClose()
        }
    }
}