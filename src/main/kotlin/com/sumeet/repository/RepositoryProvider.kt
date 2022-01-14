package com.sumeet.repository

import com.sumeet.database.DatabaseLocator
import com.sumeet.util.ExceptionHandlerImpl

object RepositoryProvider {

    fun getMainRepository() = MainRepository(DatabaseLocator.provideDatabase())

}