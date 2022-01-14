package com.sumeet.repository

import com.sumeet.database.Database
import com.sumeet.model.ServiceCar
import com.sumeet.model.ServiceLog
import com.sumeet.model.User
import com.sumeet.util.BaseResponse
import com.sumeet.util.SuccessResponse
import com.sumeet.util.UnSuccessResponse
import io.ktor.http.*
import org.litote.kmongo.eq

class MainRepository(database: Database) {

    private val usersCollection = database.userCollection
    private val serviceLogCollection = database.serviceLogCollection

    suspend fun insertNewUser(user: User): BaseResponse<Any> {
        return if (findUserByMobileNumber(user.mobileNumber) == null) {
            val insertOneResult = usersCollection.insertOne(user)
            if (insertOneResult.wasAcknowledged())
                SuccessResponse(insertOneResult.insertedId)
            else
                UnSuccessResponse(HttpStatusCode.InternalServerError, "Something went wrong")
        } else
            UnSuccessResponse(HttpStatusCode.Conflict, "User already exists with this mobile number")
    }

    suspend fun findUserByMobileNumber(mobileNumber: String?): User? {
        return usersCollection.find(User::mobileNumber eq mobileNumber).first()
    }

    suspend fun updateUserData(user: User): Boolean {
        return usersCollection.updateOne(User::userId eq user.userId,user).wasAcknowledged()
    }

    suspend fun findUserByUserId(userId: String?): User? {
        return usersCollection.findOne(User::userId eq userId)
    }

    suspend fun findServiceLogById(serviceLogId: String?): ServiceLog? {
        return serviceLogCollection.findOne(ServiceLog::_id eq serviceLogId)
    }

    suspend fun getAllLogsByCustomerId(customerId: String?): List<ServiceLog> {
        return serviceLogCollection.find(ServiceLog::customerId eq customerId).toList()
    }

    suspend fun getAllLogsByEmployeeId(employeeId: String?): List<ServiceLog> {
        return serviceLogCollection.find(ServiceLog::assignedEmployeeId eq employeeId).toList()
    }

    suspend fun getAllServiceLogs(): List<ServiceLog> {
        return serviceLogCollection.find().toList()
    }

    suspend fun getAllLogsByCarId(carId: String?): List<ServiceLog> {
        return serviceLogCollection.find(ServiceCar::carId eq carId).toList()
    }

    suspend fun insertNewServiceLog(log: ServiceLog): Boolean {
        return serviceLogCollection.insertOne(log).wasAcknowledged()
    }

    suspend fun updateServiceLog(log: ServiceLog): Boolean {
        return serviceLogCollection.updateOne(ServiceLog::_id eq log._id,log).wasAcknowledged()
    }

}