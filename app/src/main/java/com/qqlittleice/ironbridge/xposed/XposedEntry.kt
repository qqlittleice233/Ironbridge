package com.qqlittleice.ironbridge.xposed

import com.qqlittleice.ironbridge.xposed.hook.Android
import com.qqlittleice.ironbridge.xposed.hook.Self
import com.qqlittleice.ironbridge.xposed.utils.LogUtil
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.callbacks.XC_LoadPackage

class XposedEntry: IXposedHookLoadPackage {

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        Runtime.loadPackageParam = lpparam
        Runtime.classLoader = lpparam.classLoader
        when(lpparam.packageName) {
            "android" -> {
                LogUtil.xpd("hooking package name is android, start hooking")
                Android.hook()
            }
            Runtime.SelfPackage -> {
                LogUtil.xpd("start hooking myself")
                Self.hook()
            }
            else -> {
                LogUtil.xpw("hooking package name is ${lpparam.packageName}, expect android.")
            }
        }

    }

}