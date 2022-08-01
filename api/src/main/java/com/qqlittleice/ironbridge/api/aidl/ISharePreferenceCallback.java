package com.qqlittleice.ironbridge.api.aidl;

import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;

import com.qqlittleice.ironbridge.api.annotation.BridgeVersion;

@Keep
public interface ISharePreferenceCallback extends IInterface {

    @Keep
    class Default implements ISharePreferenceCallback {
        @Override
        public void onSharePreferenceChanged(String key, Object value) throws RemoteException {}

        @Override
        public IBinder asBinder() { return null; }
    }

    @Keep
    abstract class Stub extends Binder implements ISharePreferenceCallback {
        public static final String DESCRIPTOR = "com.qqlittleice.ironbridge.api.aidl.ISharePreferenceCallback";
        public static final int api = 1;

        static final int TRANSACTION_onSharePreferenceChanged = IBinder.FIRST_CALL_TRANSACTION;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISharePreferenceCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ISharePreferenceCallback)) {
                return new Proxy(obj);
            }
            return (ISharePreferenceCallback) iin;
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = DESCRIPTOR;
            switch (code) {
                case TRANSACTION_onSharePreferenceChanged:
                    data.enforceInterface(descriptor);
                    onSharePreferenceChanged(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case IBinder.INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        public static boolean setDefaultImpl(ISharePreferenceCallback impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static ISharePreferenceCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Keep
        private static class Proxy implements ISharePreferenceCallback {

            private final IBinder mRemote;
            public static ISharePreferenceCallback sDefaultImpl;

            Proxy(IBinder remote) {
                mRemote = remote;
            }

            @Override
            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onSharePreferenceChanged(String key, Object value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    if (value instanceof String) {
                        _data.writeString((String) value);
                    } else if (value instanceof Integer) {
                        _data.writeInt((Integer) value);
                    } else if (value instanceof Long) {
                        _data.writeLong((Long) value);
                    } else if (value instanceof Float) {
                        _data.writeFloat((Float) value);
                    } else if (value instanceof Boolean) {
                        _data.writeBoolean((Boolean) value);
                    } else if (value instanceof Double) {
                        _data.writeDouble((Double) value);
                    } else if (value instanceof String[]) {
                        _data.writeStringArray((String[]) value);
                    } else if (value instanceof int[]) {
                        _data.writeIntArray((int[]) value);
                    } else if (value instanceof long[]) {
                        _data.writeLongArray((long[]) value);
                    } else if (value instanceof float[]) {
                        _data.writeFloatArray((float[]) value);
                    } else if (value instanceof boolean[]) {
                        _data.writeBooleanArray((boolean[]) value);
                    } else if (value instanceof double[]) {
                        _data.writeDoubleArray((double[]) value);
                    } else {
                        throw new IllegalArgumentException("unsupported type");
                    }
                    boolean _status = mRemote.transact(TRANSACTION_onSharePreferenceChanged, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onSharePreferenceChanged(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }
    }

    @BridgeVersion(1)
    void onSharePreferenceChanged(String key, Object value) throws RemoteException;
}
