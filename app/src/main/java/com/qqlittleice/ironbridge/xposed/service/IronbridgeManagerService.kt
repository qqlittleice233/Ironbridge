package com.qqlittleice.ironbridge.xposed.service

import com.qqlittleice.ironbridge.IIronbridgeManager
import com.qqlittleice.ironbridge.rule.BridgeRule

class IronbridgeManagerService: IIronbridgeManager.Stub() {


    override fun setRule(rule: BridgeRule?): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteRule(packageName: String?, key: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun getAllRules(): MutableList<BridgeRule> {
        TODO("Not yet implemented")
    }
}