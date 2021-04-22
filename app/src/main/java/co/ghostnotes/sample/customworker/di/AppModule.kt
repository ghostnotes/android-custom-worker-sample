package co.ghostnotes.sample.customworker.di

import co.ghostnotes.sample.customworker.repository.CustomWorkerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCustomWorkerRepository(): CustomWorkerRepository = CustomWorkerRepository()

}