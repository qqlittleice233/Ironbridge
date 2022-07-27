package com.qqlittleice.ironbridge.xposed.utils

import de.robv.android.xposed.XposedBridge
import android.util.Log as ALog

object LogUtil {

    private const val maxLength = 4000
    private const val TAG = "IronBridge"
    private const val XTAG = "IronBridge"

    @JvmStatic
    private fun doLog(f: (String, String) -> Int, tag: String = TAG, obj: Any?) {
        val str = if (obj is Throwable) ALog.getStackTraceString(obj) else obj.toString()
        if (str.length > maxLength) {
            val chunkCount: Int = str.length / maxLength
            for (i in 0..chunkCount) {
                val max: Int = 4000 * (i + 1)
                if (max >= str.length) {
                    doLog(f, tag = tag, obj = str.substring(maxLength * i))
                } else {
                    doLog(f, tag = tag, obj = str.substring(maxLength * i, max))
                }
            }
        } else {
            f(tag, str)
        }
    }

    @JvmStatic
    fun _d(obj: Any?, tag: String = TAG) {
        doLog(ALog::d, tag = tag, obj = obj)
    }

    @JvmStatic
    @JvmOverloads
    fun d(obj: Any?, tag: String = TAG) {
        doLog(ALog::d, tag = tag, obj = obj)
    }

    @JvmStatic
    @JvmOverloads
    fun i(obj: Any?, tag: String = TAG) {
        doLog(ALog::i, tag = tag, obj = obj)
    }

    @JvmStatic
    @JvmOverloads
    fun e(obj: Any?, tag: String = TAG) {
        doLog(ALog::e, tag = tag, obj = obj)
    }

    @JvmStatic
    @JvmOverloads
    fun v(obj: Any?, tag: String = TAG) {
        doLog(ALog::v, tag = tag, obj = obj)
    }

    @JvmStatic
    @JvmOverloads
    fun w(obj: Any?, tag: String = TAG) {
        doLog(ALog::w, tag = tag, obj = obj)
    }

    @JvmStatic
    fun xp(obj: Any?, level: String = "normal") {
        doLog(::xposed, tag = level, obj = obj)
    }

    fun xpw(obj: Any?, level: String = "warn") {
        doLog(::xposed, tag = level, obj = obj)
    }

    fun xpd(obj: Any?, level: String = "debug") {
        doLog(::xposed, tag = level, obj = obj)
    }

    fun xpe(obj: Any?, level: String = "error") {
        doLog(::xposed, tag = level, obj = obj)
    }

    private fun xposed(level: String, msg: String): Int {
        when(level) {
            "normal" -> XposedBridge.log("[${XTAG}] $msg")
            "warn" -> XposedBridge.log("[$XTAG] warn:$msg")
            "error" -> XposedBridge.log("[$XTAG] error:$msg")
            "debug" -> XposedBridge.log("[$XTAG] debug:$msg")
            else -> XposedBridge.log("[$XTAG] $msg")
        }
        return 0
    }

}