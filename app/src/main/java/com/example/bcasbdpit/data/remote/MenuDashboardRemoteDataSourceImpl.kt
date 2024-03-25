package com.example.bcasbdpit.data.remote

import com.example.bcasbdpit.data.Service
import com.example.bcasbdpit.model.MenuDashboardResponse
import retrofit2.Response
import javax.inject.Inject

class MenuDashboardRemoteDataSourceImpl @Inject constructor(

    private val service: Service
) : MenuDashboardRemoteDataSource {

    override suspend fun getMenuDashboard(): Response<MenuDashboardResponse> {
        return service.getHomeMenu()
    }
}