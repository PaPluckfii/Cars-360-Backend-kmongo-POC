package com.sumeet.model

import org.bson.types.ObjectId

data class Car(
    var carId: String = ObjectId().toString(),
    var carBrand: String? = null,
    var carModel: String? = null,
    var bodyColor: String? = null,
    var plateNo: String? = null,
    var fuelType: String? = null,
    var insuranceCompany: String? = null,
    var insuranceExpiryDate: String? = null,
    var createdAt: String? = null,
    var modifiedAt: String? = null
)
