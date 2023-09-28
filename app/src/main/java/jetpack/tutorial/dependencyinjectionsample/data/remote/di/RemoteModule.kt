package jetpack.tutorial.dependencyinjectionsample.data.remote.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jetpack.tutorial.dependencyinjectionsample.data.remote.RemoteDataSourceImpl
import jetpack.tutorial.dependencyinjectionsample.data.remote.RemoteDataSource
import jetpack.tutorial.dependencyinjectionsample.data.remote.RemoteDataSourceTest
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RemoteModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(impl: RemoteDataSourceTest): RemoteDataSource

}