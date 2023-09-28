package jetpack.tutorial.dependencyinjectionsample.data.local.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jetpack.tutorial.dependencyinjectionsample.data.local.LocalDataSource
import jetpack.tutorial.dependencyinjectionsample.data.local.LocalDataSourceImpl
import jetpack.tutorial.dependencyinjectionsample.data.local.LocalDataSourceTest
import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDao
import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalDataModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            MovieDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(
        movieDatabase: MovieDatabase
    ): MovieDao {
        return movieDatabase.movieDao()
    }
}

@InstallIn(SingletonComponent::class)
@Module
abstract class AbsLocalModule {

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource
}