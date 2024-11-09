package com.example.feastlyandroid.di

import com.example.feastlyandroid.features.allKitchenFragment.AllKitchenRepository
import com.example.feastlyandroid.features.allKitchenFragment.AllKitchenRepositoryInterface
import com.example.feastlyandroid.features.allKitchenFragment.AllKitchenService
import com.example.feastlyandroid.features.allKitchenFragment.AllKitchenServiceInterface
import com.example.feastlyandroid.features.homeFeature.HomeService
import com.example.feastlyandroid.features.homeFeature.HomeServiceInterface
import com.example.feastlyandroid.features.homeFeature.KitchenRepository
import com.example.feastlyandroid.features.homeFeature.KitchenRepositoryInterface
import com.example.feastlyandroid.retrofit.ApiService
import com.example.feastlyandroid.retrofit.ApiUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKitchenRepository(apiService: ApiService) : KitchenRepositoryInterface {
        val service : HomeServiceInterface = HomeService(apiService)
        val repo : KitchenRepositoryInterface = KitchenRepository(service)
        return  repo
    }

    @Provides
    @Singleton
    fun provideAllKitchenRepository(apiService: ApiService) : AllKitchenRepositoryInterface {
        val service : AllKitchenServiceInterface = AllKitchenService(apiService)
        val repo : AllKitchenRepositoryInterface = AllKitchenRepository(service)
        return  repo
    }

    @Provides
    @Singleton
    fun provideApiService() : ApiService {
        return  ApiUtils.createService()
    }
}