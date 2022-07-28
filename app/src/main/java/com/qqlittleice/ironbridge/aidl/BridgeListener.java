package com.qqlittleice.ironbridge.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface BridgeListener extends IInterface {

    class Default implements BridgeListener {
        @Override
        public void onReceivedString(String tag, String value) {}
        @Override
        public void onReceivedInt(String tag, int value) {}
        @Override
        public void onReceivedLong(String tag, long value) {}
        @Override
        public void onReceivedFloat(String tag, float value) {}
        @Override
        public void onReceivedDouble(String tag, double value) {}
        @Override
        public void onReceivedBoolean(String tag, boolean value) {}
        @Override
        public IBinder asBinder() { return null; }
    }

    abstract class Stub extends Binder implements BridgeListener {

        private static final String DESCRIPTOR = "com.qqlittleice.ironbridge.aidl.BridgeListener";

        static final int TRANSACTION_onReceivedString = IBinder.FIRST_CALL_TRANSACTION;
        static final int TRANSACTION_onReceivedInt = IBinder.FIRST_CALL_TRANSACTION + 1;
        static final int TRANSACTION_onReceivedLong = IBinder.FIRST_CALL_TRANSACTION + 2;
        static final int TRANSACTION_onReceivedFloat = IBinder.FIRST_CALL_TRANSACTION + 3;
        static final int TRANSACTION_onReceivedDouble = IBinder.FIRST_CALL_TRANSACTION + 4;
        static final int TRANSACTION_onReceivedBoolean = IBinder.FIRST_CALL_TRANSACTION + 5;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BridgeListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface localInterface = obj.queryLocalInterface(DESCRIPTOR);
            if (localInterface instanceof BridgeListener) {
                return (BridgeListener)localInterface;
            }
            return new BridgeListener.Stub.Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = DESCRIPTOR;
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_onReceivedString: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    String value = data.readString();
                    onReceivedString(tag, value);
                    return true;
                }
                case TRANSACTION_onReceivedInt: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    int value = data.readInt();
                    onReceivedInt(tag, value);
                    return true;
                }
                case TRANSACTION_onReceivedLong: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    long value = data.readLong();
                    onReceivedLong(tag, value);
                    return true;
                }
                case TRANSACTION_onReceivedFloat: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    float value = data.readFloat();
                    onReceivedFloat(tag, value);
                    return true;
                }
                case TRANSACTION_onReceivedDouble: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    double value = data.readDouble();
                    onReceivedDouble(tag, value);
                    return true;
                }
                case TRANSACTION_onReceivedBoolean: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    boolean value = data.readInt() != 0;
                    onReceivedBoolean(tag, value);
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        public static boolean setDefaultImpl(BridgeListener impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static BridgeListener getDefaultImpl() {
            return Stub.Proxy.sDefaultImpl;
        }

        private static class Proxy implements BridgeListener {

            private final IBinder mRemote;
            public static BridgeListener sDefaultImpl;

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

            @Override
            public void onReceivedString(String tag, String value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeString(value);
                    boolean _status = mRemote.transact(TRANSACTION_onReceivedString, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedString(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedInt(String tag, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeInt(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedInt, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedInt(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedLong(String tag, long value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeLong(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedLong, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedLong(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedFloat(String tag, float value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeFloat(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedFloat, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedFloat(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedDouble(String tag, double value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeDouble(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedDouble, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedDouble(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedBoolean(String tag, boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeInt(value ? 1 : 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedBoolean, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedBoolean(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }
    }

    void onReceivedString(java.lang.String tag, java.lang.String value) throws android.os.RemoteException;
    void onReceivedInt(java.lang.String tag, int value) throws android.os.RemoteException;
    void onReceivedLong(java.lang.String tag, long value) throws android.os.RemoteException;
    void onReceivedFloat(java.lang.String tag, float value) throws android.os.RemoteException;
    void onReceivedDouble(java.lang.String tag, double value) throws android.os.RemoteException;
    void onReceivedBoolean(java.lang.String tag, boolean value) throws android.os.RemoteException;
}
