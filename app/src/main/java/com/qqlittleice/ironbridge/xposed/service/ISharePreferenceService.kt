package com.qqlittleice.ironbridge.xposed.service

import android.os.Binder
import com.qqlittleice.ironbridge.api.aidl.ISharePreference
import com.qqlittleice.ironbridge.api.aidl.ISharePreferenceCallback
import com.qqlittleice.ironbridge.xposed.utils.LogUtil
import com.qqlittleice.ironbridge.xposed.utils.SystemServerDirUtils
import io.fastkv.FastKV
import java.io.File

class ISharePreferenceService(name: String) : ISharePreference.Stub() {
    private val callbacks = mutableListOf<ISharePreferenceCallback>()
    private val kvStore = FastKV.Builder(File(SystemServerDirUtils.baseServerDir(), "FastKV").absolutePath, name).build()
    private val blackList = arrayListOf("__createUid__", "__scope__")

    fun setCreateUid(uid: Int) {
        kvStore.putInt("__createUid__", uid)
    }

    fun getScope(): List<String> {
        return kvStore.getStringSet("__scope__")?.toList() ?: arrayListOf()
    }

    override fun setScope(scope: Array<String>) {
        if (Binder.getCallingUid() != kvStore.getInt("__createUid__")) {
            LogUtil.e("setScope", Binder.getCallingUid().toString() + ": setScope failed, permission denied")
            throw SecurityException("Only the creator can set scope")
        }
        kvStore.putStringSet("__scope__", scope.toSet())
    }

    override fun addCallback(callback: ISharePreferenceCallback) {
        callbacks.add(callback)
    }

    override fun removeCallback(callback: ISharePreferenceCallback) {
        callbacks.remove(callback)
    }

    override fun setString(key: String, value: String) {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: setString failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        kvStore.putString(key, value)
        callbacks.forEach { it.onSharePreferenceChanged(key, value) }
    }

    override fun setStringArray(key: String, values: Array<out String>) {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: setStringArray failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        kvStore.putStringSet(key, values.toSet())
        callbacks.forEach { it.onSharePreferenceChanged(key, values.toSet()) }
    }

    override fun setInt(key: String, value: Int) {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: setInt failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        kvStore.putInt(key, value)
        callbacks.forEach { it.onSharePreferenceChanged(key, value) }
    }

    override fun setDouble(key: String, value: Double) {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: setDouble failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        kvStore.putDouble(key, value)
        callbacks.forEach { it.onSharePreferenceChanged(key, value) }
    }

    override fun setLong(key: String, value: Long) {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: setLong failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        kvStore.putLong(key, value)
        callbacks.forEach { it.onSharePreferenceChanged(key, value) }
    }

    override fun setFloat(key: String, value: Float) {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: setFloat failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        kvStore.putFloat(key, value)
        callbacks.forEach { it.onSharePreferenceChanged(key, value) }
    }

    override fun setBoolean(key: String, value: Boolean) {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: setBoolean failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        kvStore.putBoolean(key, value)
        callbacks.forEach { it.onSharePreferenceChanged(key, value) }
    }

    override fun getString(key: String, defValue: String): String {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: getString failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        return kvStore.getString(key, defValue)
    }

    override fun getStringArray(key: String, defValue: Array<String>): Array<String> {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: getStringArray failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        return kvStore.getStringSet(key)?.toTypedArray() ?: defValue
    }

    override fun getInt(key: String, defValue: Int): Int {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: getInt failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        return kvStore.getInt(key, defValue)
    }

    override fun getDouble(key: String, defValue: Double): Double {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: getDouble failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        return kvStore.getDouble(key, defValue)
    }

    override fun getLong(key: String, defValue: Long): Long {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: getLong failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        return kvStore.getLong(key, defValue)
    }

    override fun getFloat(key: String, defValue: Float): Float {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: getFloat failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        return kvStore.getFloat(key, defValue)
    }

    override fun getBoolean(key: String, defValue: Boolean): Boolean {
        if (blackList.contains(key)) {
            LogUtil.e("${Binder.getCallingUid()}: getBoolean failed, black list ($key)")
            throw SecurityException("Black list key")
        }
        return kvStore.getBoolean(key, defValue)
    }

}