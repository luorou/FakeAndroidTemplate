package com.bye.ane.feature.index.repository

import com.bye.ane.feature.index.api.IndexApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IndexRepository @Inject constructor(private val api: IndexApi) {

    fun login(): String {
        return "api.fetch()"
    }
}