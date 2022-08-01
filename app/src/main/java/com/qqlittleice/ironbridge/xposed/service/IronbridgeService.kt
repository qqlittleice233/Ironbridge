package com.qqlittleice.ironbridge.xposed.service

import android.app.AndroidAppHelper
import android.os.Binder
import android.os.IBinder
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.qqlittleice.ironbridge.api.aidl.BridgeListener
import com.qqlittleice.ironbridge.api.aidl.ISharePreference
import com.qqlittleice.ironbridge.api.aidl.Ironbridge
import com.qqlittleice.ironbridge.xposed.utils.LogUtil
import com.qqlittleice.ironbridge.xposed.utils.SystemServerDirUtils
import io.fastkv.FastKV
import io.fastkv.FastKVConfig
import java.io.File
import java.io.Serializable

class IronbridgeService: Ironbridge.Stub() {

    private val mListeners = arrayListOf<BridgeListener>()
    private val mKV = FastKV.Builder(File(SystemServerDirUtils.baseServerDir(), "Config").absolutePath, "Ironbridge").build()
    private val mKVMap: HashMap<String, ISharePreferenceService> = hashMapOf()

    init {
        FastKVConfig.setLogger(object : FastKV.Logger {
            override fun i(name: String, message: String) {
                LogUtil.i("FastKVConfig-$name: $message")
            }
            override fun w(name: String, e: Exception) {
                LogUtil.w("FastKVConfig-$name: $e")
            }
            override fun e(name: String, e: Exception) {
                LogUtil.e("FastKVConfig-$name: $e")
            }
        })
    }

    override fun addListener(iBridgeListener: BridgeListener) {
        runCatching {
            mListeners.add(iBridgeListener)
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun removeListener(iBridgeListener: BridgeListener?) {
        runCatching {
            mListeners.remove(iBridgeListener)
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendString(channel: String, key: String, value: String) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedString(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendInt(channel: String, key: String, value: Int) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedInt(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendLong(channel: String, key: String, value: Long) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedLong(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendFloat(channel: String, key: String, value: Float) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedFloat(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendDouble(channel: String, key: String, value: Double) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedDouble(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendBoolean(channel: String, key: String, value: Boolean) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedBoolean(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendStringList(channel: String?, key: String?, value: MutableList<String>?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedStringList(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendIntList(channel: String?, key: String?, value: MutableList<Int>?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedIntList(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendLongList(channel: String?, key: String?, value: MutableList<Long>?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedLongList(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendFloatList(channel: String?, key: String?, value: MutableList<Float>?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedFloatList(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendDoubleList(channel: String?, key: String?, value: MutableList<Double>?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedDoubleList(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendBooleanList(channel: String?, key: String?, value: MutableList<Boolean>?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedBooleanList(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendStringArray(channel: String?, key: String?, value: Array<out String>?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedStringArray(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendIntArray(channel: String?, key: String?, value: IntArray?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedIntArray(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendLongArray(channel: String?, key: String?, value: LongArray?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedLongArray(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendFloatArray(channel: String?, key: String?, value: FloatArray?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedFloatArray(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendDoubleArray(channel: String?, key: String?, value: DoubleArray?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedDoubleArray(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendBooleanArray(channel: String?, key: String?, value: BooleanArray?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedBooleanArray(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendParcelable(channel: String?, key: String?, value: Parcelable?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedParcelable(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendSerializable(channel: String?, key: String?, value: Serializable?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedSerializable(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendIBinder(channel: String?, key: String?, value: IBinder?) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (!binder.checkBridgeListenerVersion(1)) {
                        Log.d("IronBridge", "remote listener api version is too low, require 1")
                        continue
                    }
                    if (next.channel == channel) {
                        next.onReceivedIBinder(key, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun getSharePreference(channel: String): ISharePreference? {
        var result: ISharePreferenceService? = null
        if (mKVMap.containsKey(channel)) {
            result = mKVMap[channel]!!
        }
        if (mKV.getStringSet("SPList").contains(channel)) {
            result = ISharePreferenceService(channel)
            mKVMap[channel] = result
        }
        if (result != null) {
            if (Binder.getCallingUid() == result.getCreateUid()) {
                return result
            }
            val pList = AndroidAppHelper.currentApplication().applicationContext.packageManager.getPackagesForUid(Binder.getCallingUid()) ?: return null
            for (pName in pList) {
                if (result.getScope().contains(pName)) {
                    return result
                }
            }
            throw SecurityException("Permission denied")
        }
        return null
    }

    override fun createSharePreference(channel: String): ISharePreference {
        if (mKV.getStringSet("SPList").contains(channel) || mKVMap.containsKey(channel)) {
            throw IllegalArgumentException("SharePreference already exists: $channel")
        }
        val sp = ISharePreferenceService(channel)
        sp.setCreateUid(Binder.getCallingUid())
        mKVMap[channel] = sp
        mKV.putStringSet("SPList", mKVMap.keys)
        return sp
    }

    private fun getBridgeListenerVersion(binder: IBinder): Int {
        val data = Parcel.obtain()
        val reply = Parcel.obtain()
        try {
            data.writeInterfaceToken(BridgeListener.Stub.DESCRIPTOR)
            val status = binder.transact(BridgeListener.Stub.TRANSACTION_API, data, reply, 0)
            if (!status) {
                Log.d("IronBridge", "get remote api version failed")
                return 0
            }
            reply.readException()
            return reply.readInt()
        } finally {
            data.recycle()
            reply.recycle()
        }
    }

    private fun IBinder.checkBridgeListenerVersion(requireApi: Int): Boolean {
        return getBridgeListenerVersion(this) >= requireApi
    }

}