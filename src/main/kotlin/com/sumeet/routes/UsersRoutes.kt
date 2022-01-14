package com.sumeet.routes

import com.mongodb.client.model.Projections.fields
import com.sumeet.database.Database
import com.sumeet.model.User
import com.sumeet.repository.MainRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.bson.conversions.Bson
import org.litote.kmongo.eq
import org.litote.kmongo.util.idValue

fun Application.usersRoutes(repository: MainRepository) {

    routing {
        get("/user/{userId}") {
            val userId = call.parameters["userId"]
            val user = repository.findUserByUserId(userId)
            if (user != null)
                call.respond(HttpStatusCode.Found, user)
            else
                call.respond(HttpStatusCode.NotFound, "User not found")
        }

        post("/user/add_new") {
            val user = call.receive<User>()
            val response = repository.insertNewUser(user)
            call.respond(response)
        }

        get("/user/mobile/{mobileNumber}") {
            val mobileNumber = call.parameters["mobileNumber"]
            val user = repository.findUserByMobileNumber(mobileNumber)
            if (user != null)
                call.respond(HttpStatusCode.Found, user)
            else
                call.respond(HttpStatusCode.NotFound, "No User Found With $mobileNumber")
        }

        put("/user/update") {
            val user = call.receive<User>()
            if (repository.updateUserData(user))
                call.respond(HttpStatusCode.OK, "${user.name} User Data Update")
            else
                call.respond(HttpStatusCode.Conflict, "Can't Update, Check Data Again")
        }
    }

}