package com.bye.ane.core.network.fliter

import com.bye.ane.core.global.RespWrapper

/**
 *
 */
typealias BusinessFailBlock<T> = (resp: RespWrapper<T>) -> Boolean

/**
 *
 */
typealias ThrowableBlock = (e: Throwable) -> Boolean

/**
 *
 */
class RespFilter<T>(private val builder: Builder<T>) {
    fun process(): T? {
        if (builder.body == null) {
            return null
        }
        //
        if (builder.exception != null && builder.throwableBlock != null) {
            builder.throwableBlock?.invoke(builder.exception!!)
            return null
        }
        //
        builder.businessBlocks.forEach {
            val intercept = it.invoke(builder.body!!)
            if (intercept) {
                return null
            }
        }
        //
        return builder.body?.data
    }

    class Builder<T>() {

        internal var body: RespWrapper<T>? = null

        //
        internal var exception: Throwable? = null

        //
        internal val businessBlocks = ArrayList<BusinessFailBlock<T>>()

        //
        internal var throwableBlock: ThrowableBlock? = null

        fun setResponse(body: RespWrapper<T>?): Builder<T> {
            this.body = body
            return this
        }

        fun setException(e: Throwable): Builder<T> {
            this.exception = e
            return this
        }

        //
        fun addBusinessBlock(it: BusinessFailBlock<T>): Builder<T> {
            businessBlocks.add(it)
            return this
        }

        fun setFailureBlock(it: ThrowableBlock): Builder<T> {
            this.throwableBlock = it
            return this
        }

        //
        fun build(): RespFilter<T> {
            return RespFilter(this)
        }
    }


}