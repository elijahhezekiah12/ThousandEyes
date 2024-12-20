package com.elijahhezekiah.pinglib

import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class PingHost {

    /***
        Returns the latency to a given  host in mili-seconds by issuing a ping command.
        returns the avg latency of them.
        Returns 0 when there is no connection

       @Params hosts
     */
    fun getLatency(hosts: String): Double {
        val pingCommand = ("/system/bin/ping -c 5 ").toString() + hosts
        var inputLine = ""
        var avgRtt = 0.0
        var process: Process? = null
        try {

            runBlocking {

                // execute the command on the environment interface

                val runtime = Runtime.getRuntime()
                process = runtime.exec(pingCommand)

                // gets the input stream to get the output of the executed command
                val bufferedReader = process?.inputStream?.let { InputStreamReader(it) }
                    ?.let { BufferedReader(it) }

                println("this is is in the bufferReader ${bufferedReader?.readLine()}")

                if (process == null || bufferedReader?.readLine() == null){
                    inputLine = "unknown host"
                }
                    else{
                       while (inputLine!= null ){
                           if (inputLine.isNotEmpty() && inputLine.contains("avg")) {
                               break
                           }
                           if (bufferedReader != null) {
                               inputLine = bufferedReader.readLine()
                           }
                           print("PING RESPONSE = $inputLine")
                           println()

                       }
                }

            }

        } catch (e: IOException) {
            print("ERROR  getLatency: EXCEPTION")
            e.printStackTrace()
        }

        println("final inputline ; $inputLine")



        if (inputLine.contains("rtt ")) {
            avgRtt =
                Regex("\\d+\\.\\d+").findAll(inputLine).toList()[1].value.toDouble()
        }


          println("average latency $avgRtt")

            return avgRtt
        }



}