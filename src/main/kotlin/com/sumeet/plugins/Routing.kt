package com.sumeet.plugins

import com.sumeet.repository.RepositoryProvider
import com.sumeet.routes.imagesRoute
import com.sumeet.routes.serviceLogRoutes
import com.sumeet.routes.usersRoutes
import com.sumeet.util.AD_BANNERS_FOLDER
import com.sumeet.util.SERVICE_LOG_IMAGES_FOLDER
import com.sumeet.util.UPLOADED_IMAGES_PATH
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.content.*
import java.io.File

fun Application.configureRouting() {
    install(Routing)
    routing {

        usersRoutes(RepositoryProvider.getMainRepository())
        serviceLogRoutes(RepositoryProvider.getMainRepository())
        imagesRoute(RepositoryProvider.getMainRepository())

        static {
            staticRootFolder = File(UPLOADED_IMAGES_PATH)
            files(SERVICE_LOG_IMAGES_FOLDER)
            files(AD_BANNERS_FOLDER)
        }
    }
}
