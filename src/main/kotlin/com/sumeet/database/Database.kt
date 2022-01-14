package com.sumeet.database

import com.sumeet.model.ServiceLog
import com.sumeet.model.User
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase

interface Database {

    val initializeName: String

    val mongoClient: CoroutineClient

    val database: CoroutineDatabase

    val userCollection: CoroutineCollection<User>

    val serviceLogCollection: CoroutineCollection<ServiceLog>

    //Adding more collections
//    val serviceLogsCollection: CoroutineCollection<ServiceLogs>

}