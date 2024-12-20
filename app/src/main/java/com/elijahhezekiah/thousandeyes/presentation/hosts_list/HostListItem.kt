package com.elijahhezekiah.thousandeyes.presentation.hosts_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.elijahhezekiah.thousandeyes.R
import com.elijahhezekiah.thousandeyes.model.HostsModelItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HostListItem(
    hostsModelItem: HostsModelItem,
    viewModel: HostsListViewModel = hiltViewModel()
) {

    val painter = rememberImagePainter(data =hostsModelItem.icon) {
        crossfade(durationMillis = 1000)
        error(R.drawable.ic_placeholder)
        placeholder(R.drawable.ic_placeholder)
    }
    val coroutineScope = rememberCoroutineScope()
    var avgLatency by remember { mutableDoubleStateOf(0.0) }

    LaunchedEffect(hostsModelItem.name) {
        coroutineScope.launch {
                avgLatency = viewModel.returnHostLatency(hostsModelItem.url)

        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

       Box(
           modifier = Modifier
               .height(80.dp)
               .width(80.dp)
               .wrapContentSize()
               .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painter,
                contentDescription = hostsModelItem.name,
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = hostsModelItem.name,
            style = MaterialTheme.typography.labelSmall,
            overflow = TextOverflow.Ellipsis
            )

        Text(
            text = "$avgLatency",
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelSmall,
            overflow = TextOverflow.Ellipsis
        )


    }

}