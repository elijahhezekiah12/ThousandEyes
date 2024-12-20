package com.elijahhezekiah.thousandeyes.data.repository

import com.elijahhezekiah.thousandeyes.data.HostsApi
import com.elijahhezekiah.thousandeyes.domain.HostRepository
import com.elijahhezekiah.thousandeyes.model.HostsModel
import retrofit2.Response
import javax.inject.Inject

class HostRepositoryImpl @Inject constructor(
    private val api: HostsApi
) : HostRepository {
    override suspend fun getHosts(): Response<HostsModel> {
        return api.getHosts()
    }

}