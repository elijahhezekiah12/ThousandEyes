package com.elijahhezekiah.thousandeyes.presentation.hosts_list

import com.elijahhezekiah.thousandeyes.model.HostsModelItem

data class HostsListState(
    val isLoading: Boolean = false,
    val hosts: List<HostsModelItem> = emptyList(),
    val error: String = ""
)
