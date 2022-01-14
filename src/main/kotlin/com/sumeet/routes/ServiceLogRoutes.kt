package com.sumeet.routes

import com.sumeet.model.ServiceLog
import com.sumeet.repository.MainRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.serviceLogRoutes(repository: MainRepository){

    routing {

        get("/service_logs/id/{serviceLogId}") {
            val serviceLogId = call.parameters["serviceLogId"]
            val serviceLog = repository.findServiceLogById(serviceLogId)
            if (serviceLog != null)
                call.respond(HttpStatusCode.Found, serviceLog)
            else
                call.respond(HttpStatusCode.NotFound, "Log not found")
        }

        get("/service_logs/customer/{customerId}"){
            val customerId = call.parameters["customerId"]
            val logs = repository.getAllLogsByCustomerId(customerId)
            call.respond(HttpStatusCode.OK,logs)
        }

        get("/service_logs/employee/{employeeId}"){
            val employeeId = call.parameters["employeeId"]
            val logs = repository.getAllLogsByEmployeeId(employeeId)
            call.respond(HttpStatusCode.OK,logs)
        }

        get("/service_logs") {
            val logs = repository.getAllServiceLogs()
            call.respond(logs)
        }

        get("/service_logs/cars/{carId}") {
            val carId = call.parameters["carId"]
            val logs = repository.getAllLogsByCarId(carId)
            call.respond(HttpStatusCode.OK,logs)
        }

        post("/service_logs") {
            val log = call.receive<ServiceLog>()
            if(repository.insertNewServiceLog(log))
                call.respond(HttpStatusCode.Created,"New Service Log Is Created")
            else
                call.respond(HttpStatusCode.Conflict,"Can't Create, Check Data Again")
        }

        put("/service_logs") {
            val log = call.receive<ServiceLog>()
            if(repository.updateServiceLog(log))
                call.respond(HttpStatusCode.OK,"Service Log Updated of Customer ${log.customerName}")
            else
                call.respond(HttpStatusCode.Conflict,"Can't Update, Check Data Again")
        }

    }

}