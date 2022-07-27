// IIronbridgeManager.aidl
package com.qqlittleice.ironbridge;

import com.qqlittleice.ironbridge.rule.BridgeRule;

interface IIronbridgeManager {

    boolean setRule(in BridgeRule rule);

    boolean deleteRule(String packageName);

    List<BridgeRule> getAllRules();

}