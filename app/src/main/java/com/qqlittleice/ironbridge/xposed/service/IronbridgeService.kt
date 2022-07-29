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

    override fun sendString(channel: String, value: String) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (next.channel == channel) {
                        next.onReceivedString(channel, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendInt(channel: String, value: Int) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (next.channel == channel) {
                        next.onReceivedInt(channel, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendLong(channel: String, value: Long) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (next.channel == channel) {
                        next.onReceivedLong(channel, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendFloat(channel: String, value: Float) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (next.channel == channel) {
                        next.onReceivedFloat(channel, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendDouble(channel: String, value: Double) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (next.channel == channel) {
                        next.onReceivedDouble(channel, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendBoolean(channel: String, value: Boolean) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                val binder = next.asBinder()
                if (binder.pingBinder()) {
                    if (next.channel == channel) {
                        next.onReceivedBoolean(channel, value)
                    }
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }


}