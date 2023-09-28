package jetpack.tutorial.dependencyinjectionsample.data.local

import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDbModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalDataSourceTest @Inject constructor() : LocalDataSource {

    override fun getAllMoviesFromDb(): Flow<List<MovieDbModel>> {
        return flow { emit(mockLocalData) }
    }

    override suspend fun insertMovieToDb(movieDbModel: MovieDbModel) {
        mockLocalData.add(movieDbModel)
    }

    override suspend fun deleteMovieFromDb(movieDbModel: MovieDbModel) {
        mockLocalData.remove(movieDbModel)
    }

    private val mockLocalData = mutableListOf(
        MovieDbModel(
            name = "Inception",
            publicationDate = "2010-07-16"
        ),

        MovieDbModel(
            name = "The Shawshank Redemption",
            publicationDate = "1994-09-23"
        ),

        MovieDbModel(
            name = "The Dark Knight",
            publicationDate = "2008-07-18"
        ),

        MovieDbModel(
            name = "Pulp Fiction",
            publicationDate = "1994-10-14"
        ),

        MovieDbModel(
            name = "Forrest Gump",
            publicationDate = "1994-07-06"
        ),
        MovieDbModel(
            name = "The Matrix",
            publicationDate = "1999-03-31"
        ),

        MovieDbModel(
            name = "Gladiator",
            publicationDate = "2000-05-05"
        ),

        MovieDbModel(
            name = "Avatar",
            publicationDate = "2009-12-18"
        ),

        MovieDbModel(
            name = "Jurassic Park",
            publicationDate = "1993-06-11"
        ),

        MovieDbModel(
            name = "Titanic",
            publicationDate = "1997-12-19"
        )
    )
}