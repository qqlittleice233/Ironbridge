package com.qqlittleice.ironbridge.xposed.service

import com.qqlittleice.ironbridge.IBridgeListener
import com.qqlittleice.ironbridge.IIronbridge

class IronbridgeService: IIronbridge.Stub() {

    private val mListeners = arrayListOf<IBridgeListener>()

    override fun addListener(iBridgeListener: IBridgeListener) {
        mListeners.add(iBridgeListener)
    }

    override fun removeListener(iBridgeListener: IBridgeListener?) {
        mListeners.remove(iBridgeListener)
    }

    override fun sendString(tag: String, value: String) {
        mListeners.forEach {
            if (it.asBinder().isBinderAlive) {
                it.onReceivedString(tag, value)
            } else {
                mListeners.remove(it)
            }
        }
    }

    override fun sendInt(tag: String, value: Int) {
        mListeners.forEach {
            if (it.asBinder().isBinderAlive) {
                it.onReceivedInt(tag, value)
            } else {
                mListeners.remove(it)
            }
        }
    }

    override fun sendLong(tag: String, value: Long) {
        mListeners.forEach {
            if (it.asBinder().isBinderAlive) {
                it.onReceivedLong(tag, value)
            } else {
                mListeners.remove(it)
            }
        }
    }

    override fun sendFloat(tag: String, value: Float) {
        mListeners.forEach {
            if (it.asBinder().isBinderAlive) {
                it.onReceivedFloat(tag, value)
            } else {
                mListeners.remove(it)
            }
        }
    }

    override fun sendDouble(tag: String, value: Double) {
        mListeners.forEach {
            if (it.asBinder().isBinderAlive) {
                it.onReceivedDouble(tag, value)
            } else {
                mListeners.remove(it)
            }
        }
    }

    override fun sendBoolean(tag: String, value: Boolean) {
        mListeners.forEach {
            if (it.asBinder().isBinderAlive) {
                it.onReceivedBoolean(tag, value)
            } else {
                mListeners.remove(it)
            }
        }
    }


}