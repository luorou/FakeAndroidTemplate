package com.bye.ane.feature.index.repository

import android.widget.Toast
import com.bye.ane.core.cheaps.onFailureHandler
import com.bye.ane.core.cheaps.reLoginHandler
import com.bye.ane.core.cheaps.showRespToastHandler
import com.bye.ane.core.global.RespWrapper
import com.bye.ane.core.network.fliter.RespFilter
import com.bye.ane.feature.index.api.IndexApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IndexRepository @Inject constructor(private val api: IndexApi) {

    suspend fun login(): String? {
        val filter = RespFilter.Builder<String>()
            .addBusinessBlock { showRespToastHandler(it) }
            .addBusinessBlock { reLoginHandler(it) }
        kotlin.runCatching {
            api.login()
        }.onFailure { e ->
            filter.setException(e)
                .setFailureBlock { onFailureHandler(e) }
        }
        return filter.build().process()
    }

}
