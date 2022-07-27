// IIronbridge.aidl
package com.qqlittleice.ironbridge;

import com.qqlittleice.ironbridge.IBridgeListener;

interface IIronbridge {
    oneway void addListener(in IBridgeListener iBridgeListener);
    oneway void removeListener(in IBridgeListener iBridgeListener);

    oneway void sendString(String tag, String value);
    oneway void sendInt(String tag, int value);
    oneway void sendLong(String tag, long value);
    oneway void sendFloat(String tag, float value);
    oneway void sendDouble(String tag, double value);
    oneway void sendBoolean(String tag, boolean value);
}