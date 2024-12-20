package com.elijahhezekiah.thousandeyes.domain

import com.elijahhezekiah.thousandeyes.commons.Resource
import com.elijahhezekiah.thousandeyes.model.HostsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetHostUseCase  @Inject constructor(
    private val repository: HostRepository
) {
    operator  fun invoke(): Flow<Resource<HostsModel>> = flow {

       try {

         emit(Resource.Loading())

          val hosts = repository.getHosts().body()

          emit(Resource.Success(hosts))

        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }

    }
}