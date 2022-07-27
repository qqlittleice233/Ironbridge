package com.qqlittleice.ironbridge.xposed

import com.qqlittleice.ironbridge.xposed.hook.Android
import com.qqlittleice.ironbridge.xposed.utils.LogUtil
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.callbacks.XC_LoadPackage

class XposedEntry: IXposedHookLoadPackage {

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != "android") {
            LogUtil.xpw("hooking package name is ${lpparam.packageName}, expect android, return")
            return
        }
        LogUtil.xpd("hooking package name is android, start hook")
        Runtime.loadPackageParam = lpparam
        Runtime.classLoader = lpparam.classLoader
        Android.hook()
    }

}