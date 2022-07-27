package com.qqlittleice.ironbridge.xposed.hook

import com.qqlittleice.ironbridge.xposed.utils.LogUtil

object Android {

    fun hook() {
        runCatching {

        }.onFailure { LogUtil.xpe(it) }
    }

}