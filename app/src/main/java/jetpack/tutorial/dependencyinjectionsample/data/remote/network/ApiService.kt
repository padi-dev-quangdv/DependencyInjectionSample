package jetpack.tutorial.dependencyinjectionsample.data.remote.network

import MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Header("Authorization") authorization: String
    ): Call<MovieResponse>
}