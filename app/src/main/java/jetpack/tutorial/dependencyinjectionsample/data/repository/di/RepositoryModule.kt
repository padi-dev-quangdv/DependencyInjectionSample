package jetpack.tutorial.dependencyinjectionsample.data.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import jetpack.tutorial.dependencyinjectionsample.data.local.LocalDataSource
import jetpack.tutorial.dependencyinjectionsample.data.remote.RemoteDataSource
import jetpack.tutorial.dependencyinjectionsample.data.repository.MainRepository
import jetpack.tutorial.dependencyinjectionsample.data.repository.MainRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource,
    ): MainRepository {
        return MainRepositoryImpl(localDataSource, remoteDataSource)
    }
}