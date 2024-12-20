package com.elijahhezekiah.thousandeyes.di

import com.elijahhezekiah.thousandeyes.commons.Constants
import com.elijahhezekiah.thousandeyes.data.HostsApi
import com.elijahhezekiah.thousandeyes.data.repository.HostRepositoryImpl
import com.elijahhezekiah.thousandeyes.domain.HostRepository
import com.elijahhezekiah.thousandeyes.domain.PingService
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
    fun getHostApi(): HostsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HostsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHostsRepository(api: HostsApi): HostRepository {
        return HostRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun proivdesPingService(): PingService {
        return PingService()
    }
}