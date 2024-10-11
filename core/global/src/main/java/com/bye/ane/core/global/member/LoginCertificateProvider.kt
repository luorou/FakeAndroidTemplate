package com.bye.ane.core.global.member

import android.content.Context

object LoginCertificateProvider {
    //
    private var loginCertificate: LoginCertificate? = null

    /**
     *
     */
    @Synchronized
    fun getLoginCertificate(ctx: Context): LoginCertificate? {
        if (loginCertificate == null) {
            val cache = LoginCertificate().getCache(ctx)
            loginCertificate = cache
        }
        return loginCertificate
    }

    /**
     *
     */
    @Synchronized
    fun setLoginCertificate(ctx: Context, certificate: LoginCertificate) {
        loginCertificate = certificate
        loginCertificate?.cache(ctx)
    }
}