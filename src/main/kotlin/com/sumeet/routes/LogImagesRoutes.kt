package com.sumeet.routes

import com.sumeet.repository.MainRepository
import com.sumeet.util.BASE_URL
import com.sumeet.util.SERVICE_LOG_IMAGES_FOLDER
import com.sumeet.util.UPLOADED_IMAGES_PATH
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import java.io.File

fun Application.imagesRoute(repository: MainRepository){

    routing {

        var fileDescription = ""
        var fileName = ""

        post("/log_image") {
            val multipartData = call.receiveMultipart()
            multipartData.forEachPart { part ->
                when (part) {
                    is PartData.FormItem -> {
                        fileDescription = part.value
                    }
                    is PartData.FileItem -> {
                        fileName = part.originalFileName as String
                        val fileBytes = part.streamProvider().readBytes()
                        File("$UPLOADED_IMAGES_PATH/$SERVICE_LOG_IMAGES_FOLDER/$fileName").writeBytes(fileBytes)
                    }
                    else -> {
                        call.respond(HttpStatusCode.ExpectationFailed,"Upload Failed, Try Again")
                    }
                }
            }
            call.respond(HttpStatusCode.Created,"$BASE_URL/$fileName")
        }

    }

}