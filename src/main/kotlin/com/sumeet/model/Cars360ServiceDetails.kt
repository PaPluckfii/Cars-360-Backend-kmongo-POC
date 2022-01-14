package com.sumeet.model

import org.bson.types.ObjectId

data class Cars360ServiceDetails(
    var id: String = ObjectId().toString(),
    var serviceName: String? = null,
    var type: String? = null
)