package com.qqlittleice.ironbridge.xposed

import de.robv.android.xposed.callbacks.XC_LoadPackage

object Runtime {

    lateinit var loadPackageParam: XC_LoadPackage.LoadPackageParam
    lateinit var classLoader: ClassLoader

}