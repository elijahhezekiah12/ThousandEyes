package com.elijahhezekiah.thousandeyes.presentation.hosts_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elijahhezekiah.thousandeyes.commons.Resource
import com.elijahhezekiah.thousandeyes.domain.GetHostUseCase
import com.elijahhezekiah.thousandeyes.domain.PingService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class HostsListViewModel @Inject constructor(
    private val getHostUseCase: GetHostUseCase,
    private val pingService: PingService
) : ViewModel(){

    private val _state = mutableStateOf(HostsListState())
    val state: State<HostsListState> = _state


    init {
        getHosts()
    }

    private fun getHosts() {
        getHostUseCase().onEach {  result ->

            when(result) {
                is Resource.Success ->  {
                    _state.value = HostsListState(hosts = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = HostsListState(
                            error = result.message?: "An unexpected error occurred"
                    )

                }

                is Resource.Loading -> {
                    _state.value = HostsListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }




    suspend fun returnHostLatency (hosts:String): Double  = coroutineScope{

            withContext((Dispatchers.IO)){

             val avgLatency  = pingService.pingHostFiver(hosts)

               return@withContext avgLatency
            }

        }
    }