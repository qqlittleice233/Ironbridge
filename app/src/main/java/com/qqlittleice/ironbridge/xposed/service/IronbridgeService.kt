package com.qqlittleice.ironbridge.xposed.service

import android.os.IBinder
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.qqlittleice.ironbridge.api.aidl.BridgeListener
import com.qqlittleice.ironbridge.api.aidl.Ironbridge
import com.qqlittleice.ironbridge.xposed.utils.LogUtil
import java.io.Serializable

class IronbridgeService: Ironbridge.Stub() {

    private val mListeners = arrayListOf<BridgeListener>()

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