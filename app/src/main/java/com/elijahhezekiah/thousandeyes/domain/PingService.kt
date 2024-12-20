package com.elijahhezekiah.thousandeyes.domain

import com.elijahhezekiah.pinglib.PingHost

/***
 * This class contains the ping host function
 */
class PingService {

    fun pingHostFiver(hosts :String): Double {
       return PingHost().getLatency(hosts)
    }

}