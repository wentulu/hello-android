package com.start.network.utils

import android.util.Log

interface INetWorkLog {

    fun verbose(tag: String, msg: String)

    fun debug(tag: String, msg: String)

    fun info(tag: String, msg: String)

    fun warn(tag: String, msg: String)

    fun error(tag: String, msg: String, throwable: Throwable?)

}

object NetWorkLogNone : INetWorkLog {

    var LOG_TYPE = 1

    override fun verbose(tag: String, msg: String) {
        if (LOG_TYPE >= Log.VERBOSE)
            Log.v(tag, msg)
    }

    override fun debug(tag: String, msg: String) {
        if (LOG_TYPE >= Log.DEBUG)
            Log.d(tag, msg)
    }

    override fun info(tag: String, msg: String) {
        if (LOG_TYPE >= Log.INFO)
            Log.i(tag, msg)
    }

    override fun warn(tag: String, msg: String) {
        if (LOG_TYPE >= Log.WARN)
            Log.w(tag, msg)
    }

    override fun error(tag: String, msg: String, throwable: Throwable?) {
        if (LOG_TYPE >= Log.ERROR)
            Log.e(tag, msg, throwable)
    }

}