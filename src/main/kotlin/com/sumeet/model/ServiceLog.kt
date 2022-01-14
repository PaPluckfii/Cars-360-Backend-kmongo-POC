package com.sumeet.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class ServiceLog(
    @BsonId
    var _id: String = ObjectId().toString(),
    var status: String? = null,
    var assignedEmployeeId: String? = null,
    var assignedEmployeeName: String? = null,
    var assignedEmployeeNumber: String? = null,
    var customerMobileNumber: String? = null,
    var customerId: String? = null,
    var customerName: String? = null,
    var car: ServiceCar? = null,
    var accessoriesList: List<String>? = null,
    var accessoriesRemark: String? = null,
    var picturesAtArrival: ServiceLogPictures? = null,
    var picturesAtDeparture: ServiceLogPictures? = null,
    var billing: Billing? = null,
    var estimatedCompletionDateAndTime: String? = null,
    var dateAndTimeOfCompletion: String? = null,
    var dateAndTimeOfArrival: String? = null,
    var services: List<Service>? = null,
    var estimates: List<Estimate>? = null,
    var createdAt: String? = null,
    var modifiedAt: String? = null
)

data class ServiceCar(
    var carId: String? = null,
    var carBrand: String? = null,
    var carModel: String? = null,
    var bodyColor: String? = null,
    var plateNo: String? = null,
    var fuelType: String? = null,
    var insuranceCompany: String? = null,
    var insuranceExpiryDate: String? = null
)