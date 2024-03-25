package com.example.bcasbdpit.di

import com.example.bcasbdpit.data.Service
import com.example.bcasbdpit.data.remote.MenuDashboardRemoteDataSource
import com.example.bcasbdpit.data.remote.MenuDashboardRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MenuModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDataSource(service: Service): MenuDashboardRemoteDataSource {
        return MenuDashboardRemoteDataSourceImpl(service)
    }
}