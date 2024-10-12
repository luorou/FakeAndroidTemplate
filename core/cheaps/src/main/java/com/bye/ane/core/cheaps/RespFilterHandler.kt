package com.bye.ane.core.cheaps

import com.bye.ane.core.global.RespWrapper
import com.example.xlulibrary.Location
import com.example.xlulibrary.ToastBox
import com.example.xlulibrary.ToastTextStyle

@Synchronized
fun <T> showRespToastHandler(resp: RespWrapper<T>): Boolean {
    if (resp.code == "200") {
        return false
    }
    if (!resp.message.isNullOrEmpty()) {
        ToastBox.setParams(
            location = Location.CENTER,
            defaultTextStyle = ToastTextStyle.Black,
            anim = com.example.xlulibrary.R.style.ToastAnim_ALPHA,
        ).showToast(resp.message, false)
    }
    return true
}

@Synchronized
fun <T> reLoginHandler(resp: RespWrapper<T>): Boolean {

    if (resp.code == "4001") {
        // 重新登录

        return true
    }
    return false
}


fun onFailureHandler(e: Throwable): Boolean {

    if (e is IllegalStateException) {

    } else if (e is IllegalArgumentException) {

    }

    return false
}

