package com.qqlittleice.ironbridge.xposed.hook

import com.kaisar.xservicemanager.XServiceManager
import com.qqlittleice.ironbridge.xposed.utils.LogUtil

object Android {

    fun hook() {
        runCatching {
            XServiceManager.initForSystemServer()
        }.onFailure { LogUtil.xpe(it) }
    }

}