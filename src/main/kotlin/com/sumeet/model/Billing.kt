package com.sumeet.model

data class Billing(
    var actualCost: Double? = null,
    var createdAt: String? = null,
    var isPaid: Boolean? = null,
    var modifiedAt: String? = null,
    var originalEstimate: Double? = null,
    var paymentMode: String? = null
)