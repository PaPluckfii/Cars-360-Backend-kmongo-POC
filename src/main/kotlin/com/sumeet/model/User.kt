package com.sumeet.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class User(
    @BsonId
    val userId: String = ObjectId().toString(),
    var mobileNumber: String? = null,
    var role: String? = null,
    var name: String? = null,
    var firebaseId: String? = null,
    var emailId: String? = null,
    var address: Address? = null,
    var dob: String? = null,
    var dom: String? = null,
    var gstNo: String? = null,
    var cars: List<Car>? = null,
    var userImageUrl: String? = null,
    var createdAt: String? = null,
    var updatedAt: String? = null
)
