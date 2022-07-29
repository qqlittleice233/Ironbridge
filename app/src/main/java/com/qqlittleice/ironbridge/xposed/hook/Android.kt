package com.qqlittleice.ironbridge.xposed.hook

import com.kaisar.xservicemanager.XServiceManager
import com.qqlittleice.ironbridge.xposed.service.IronbridgeService
import com.qqlittleice.ironbridge.xposed.utils.LogUtil

object Android {

    fun hook() {
        runCatching {
            XServiceManager.initForSystemServer()
            XServiceManager.debug(true)
            XServiceManager.addService("public", IronbridgeService())
        }.onFailure { LogUtil.xpe(it) }
    }

}