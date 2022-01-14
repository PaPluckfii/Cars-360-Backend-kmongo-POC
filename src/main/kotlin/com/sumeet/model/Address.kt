package com.sumeet.model

data class Address(
    var addressLine1: String? = null,
    var addressLine2: String? = null,
    var city: String? = null,
    var state: String? = null,
    var postalCode: Int? = null
)