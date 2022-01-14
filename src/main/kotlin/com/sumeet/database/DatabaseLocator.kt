package com.sumeet.database

object DatabaseLocator {

    private fun provideClientName(): String {
        return "Cars-360-Raipur"
    }

    fun provideDatabase(): Database {
        return DatabaseImpl(provideClientName())
    }
}