package com.app.googlerepolist.di

import com.app.googlerepolist.common.Constants
import com.app.googlerepolist.data.remote.GoogleRepoApi
import com.app.googlerepolist.data.repository.RepoRepositoryImpl
import com.app.googlerepolist.domain.repository.RepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGoogleRepoApi(): GoogleRepoApi {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GoogleRepoApi::class.java)

    }

    @Provides
    @Singleton
    fun provideGoogleRepository(api : GoogleRepoApi): RepoRepository {
        return RepoRepositoryImpl(api = api)
    }
}