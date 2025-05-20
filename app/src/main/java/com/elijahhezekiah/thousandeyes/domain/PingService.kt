package com.elijahhezekiah.thousandeyes.domain

import com.elijahhezekiah.pinglib.PingHost

/***
 * This class contains the ping host function
 */
class PingService {

    suspend fun pingHostFiver(hosts :String): Double {
       return PingHost().getLatency(hosts)
    }

}