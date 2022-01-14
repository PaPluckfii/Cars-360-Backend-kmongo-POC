package com.sumeet

import com.sumeet.plugins.configureRouting
import com.sumeet.plugins.configureSecurity
import com.sumeet.plugins.configureSerialization
import io.ktor.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureRouting()
    configureSerialization()
    configureSecurity()
}
