package com.elijahhezekiah.thousandeyes.presentation.hosts_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun HostListScreen(
    viewModel: HostsListViewModel = hiltViewModel()
) {

    Spacer(modifier = Modifier.width(10.dp)
                              .height(30.dp)
                                             )
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {


   Spacer(modifier = Modifier.height(15.dp))


        val state = viewModel.state.value
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.hosts) { host ->
                    HostListItem(hostsModelItem = host)

                }

            }


        }

    }
}