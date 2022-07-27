package com.qqlittleice.ironbridge.rule;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class BridgeRule implements Parcelable {

    public final String packageName;

    public final String serviceName;

    public final List<String> scope;

    protected BridgeRule(String packageName, String serviceName, List<String> scope) {
        this.packageName = packageName;
        this.serviceName = serviceName;
        this.scope = scope;
    }

    protected BridgeRule(Parcel in) {
        packageName = in.readString();
        serviceName = in.readString();
        scope = in.createStringArrayList();
    }

    public static final Creator<BridgeRule> CREATOR = new Creator<BridgeRule>() {
        @Override
        public BridgeRule createFromParcel(Parcel in) {
            return new BridgeRule(in);
        }

        @Override
        public BridgeRule[] newArray(int size) {
            return new BridgeRule[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(packageName);
        parcel.writeString(serviceName);
        parcel.writeStringList(scope);
    }
}
