package jetpack.tutorial.dependencyinjectionsample.data.local.entity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM table_movie")
    fun getAllMoviesFromDb(): Flow<List<MovieDbModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovieToDb(vararg movieDbModel: MovieDbModel)

    @Delete
    fun deleteMovieFromDb(movieDbModel: MovieDbModel)
}