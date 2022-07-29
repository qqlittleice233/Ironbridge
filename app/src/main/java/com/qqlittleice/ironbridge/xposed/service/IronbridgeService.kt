package com.qqlittleice.ironbridge.xposed.service

import com.qqlittleice.ironbridge.aidl.BridgeListener
import com.qqlittleice.ironbridge.aidl.Ironbridge
import com.qqlittleice.ironbridge.xposed.utils.LogUtil

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


}