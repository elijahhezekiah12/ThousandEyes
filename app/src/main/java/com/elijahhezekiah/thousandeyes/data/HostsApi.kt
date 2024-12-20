package com.elijahhezekiah.thousandeyes.data

import com.elijahhezekiah.thousandeyes.model.HostsModel
import retrofit2.Response
import retrofit2.http.GET

interface HostsApi {

    @GET("sk_hosts")
    suspend fun getHosts(): Response<HostsModel>

}