// IBridgeListener.aidl
package com.qqlittleice.ironbridge;

interface IBridgeListener {
    oneway void onReceivedString(String tag, String value);
    oneway void onReceivedInt(String tag, int value);
    oneway void onReceivedLong(String tag, long value);
    oneway void onReceivedFloat(String tag, float value);
    oneway void onReceivedDouble(String tag, double value);
    oneway void onReceivedBoolean(String tag, boolean value);

}