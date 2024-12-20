package com.elijahhezekiah.thousandeyes.domain

import com.elijahhezekiah.thousandeyes.model.HostsModel
import retrofit2.Response

interface HostRepository {

    suspend fun getHosts(): Response<HostsModel>
}