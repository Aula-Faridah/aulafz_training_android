package com.example.bcasbdpit.data.remote

import com.example.bcasbdpit.model.MenuDashboardResponse
import retrofit2.Response

interface MenuDashboardRemoteDataSource  {
    suspend fun getMenuDashboard() : Response<MenuDashboardResponse>
}