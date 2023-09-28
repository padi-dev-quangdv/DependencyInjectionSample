package jetpack.tutorial.dependencyinjectionsample.data.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieDbModel::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        const val DATABASE_NAME = "movie_db"
    }
}