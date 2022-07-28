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
            mListeners.forEach {
                if (it.asBinder().isBinderAlive) {
                    it.onReceivedString(tag, value)
                } else {
                    mListeners.remove(it)
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendInt(tag: String, value: Int) {
        runCatching {
            mListeners.forEach {
                if (it.asBinder().isBinderAlive) {
                    it.onReceivedInt(tag, value)
                } else {
                    mListeners.remove(it)
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendLong(tag: String, value: Long) {
        runCatching {
            mListeners.forEach {
                if (it.asBinder().isBinderAlive) {
                    it.onReceivedLong(tag, value)
                } else {
                    mListeners.remove(it)
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendFloat(tag: String, value: Float) {
        runCatching {
            mListeners.forEach {
                if (it.asBinder().isBinderAlive) {
                    it.onReceivedFloat(tag, value)
                } else {
                    mListeners.remove(it)
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendDouble(tag: String, value: Double) {
        runCatching {
            mListeners.forEach {
                if (it.asBinder().isBinderAlive) {
                    it.onReceivedDouble(tag, value)
                } else {
                    mListeners.remove(it)
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }

    override fun sendBoolean(tag: String, value: Boolean) {
        runCatching {
            mListeners.forEach {
                if (it.asBinder().isBinderAlive) {
                    it.onReceivedBoolean(tag, value)
                } else {
                    mListeners.remove(it)
                }
            }
        }.onFailure { LogUtil.xpe(it) }
    }


}