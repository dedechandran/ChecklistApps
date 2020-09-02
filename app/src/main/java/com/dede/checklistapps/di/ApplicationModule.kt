package com.dede.checklistapps.di

import com.dede.checklistapps.data.api.ApiHelper
import com.dede.checklistapps.data.api.ApiHelperImpl
import com.dede.checklistapps.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://18.141.178.15:8080/")
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit : Retrofit) : ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelperImpl : ApiHelperImpl) : ApiHelper = apiHelperImpl
}