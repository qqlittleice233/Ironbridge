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

    override fun sendString(tag: String, value: String) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                if (next.asBinder().pingBinder()) {
                    next.onReceivedString(tag, value)
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendInt(tag: String, value: Int) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                if (next.asBinder().pingBinder()) {
                    next.onReceivedInt(tag, value)
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendLong(tag: String, value: Long) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                if (next.asBinder().pingBinder()) {
                    next.onReceivedLong(tag, value)
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendFloat(tag: String, value: Float) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                if (next.asBinder().pingBinder()) {
                    next.onReceivedFloat(tag, value)
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendDouble(tag: String, value: Double) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                if (next.asBinder().pingBinder()) {
                    next.onReceivedDouble(tag, value)
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendBoolean(tag: String, value: Boolean) {
        runCatching {
            val iterator = mListeners.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                if (next.asBinder().pingBinder()) {
                    next.onReceivedBoolean(tag, value)
                } else {
                    LogUtil.xpw("One of the listeners is dead, remove it")
                    iterator.remove()
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }


}