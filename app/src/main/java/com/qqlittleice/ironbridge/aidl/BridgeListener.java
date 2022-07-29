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
        public void onReceivedString(String channel, String value) {}
        @Override
        public void onReceivedInt(String channel, int value) {}
        @Override
        public void onReceivedLong(String channel, long value) {}
        @Override
        public void onReceivedFloat(String channel, float value) {}
        @Override
        public void onReceivedDouble(String channel, double value) {}
        @Override
        public void onReceivedBoolean(String channel, boolean value) {}
        @Override
        public String getChannel() { return null; }
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
        static final int TRANSACTION_getChannel = IBinder.FIRST_CALL_TRANSACTION + 6;

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
                    String channel = data.readString();
                    String value = data.readString();
                    onReceivedString(channel, value);
                    return true;
                }
                case TRANSACTION_onReceivedInt: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    int value = data.readInt();
                    onReceivedInt(channel, value);
                    return true;
                }
                case TRANSACTION_onReceivedLong: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    long value = data.readLong();
                    onReceivedLong(channel, value);
                    return true;
                }
                case TRANSACTION_onReceivedFloat: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    float value = data.readFloat();
                    onReceivedFloat(channel, value);
                    return true;
                }
                case TRANSACTION_onReceivedDouble: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    double value = data.readDouble();
                    onReceivedDouble(channel, value);
                    return true;
                }
                case TRANSACTION_onReceivedBoolean: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    boolean value = data.readInt() != 0;
                    onReceivedBoolean(channel, value);
                    return true;
                }
                case TRANSACTION_getChannel: {
                    data.enforceInterface(descriptor);
                    String _result = getChannel();
                    reply.writeNoException();
                    reply.writeString(_result);
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
            public void onReceivedString(String channel, String value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(value);
                    boolean _status = mRemote.transact(TRANSACTION_onReceivedString, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedString(channel, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedInt(String channel, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeInt(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedInt, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedInt(channel, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedLong(String channel, long value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeLong(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedLong, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedLong(channel, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedFloat(String channel, float value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeFloat(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedFloat, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedFloat(channel, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedDouble(String channel, double value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeDouble(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedDouble, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedDouble(channel, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedBoolean(String channel, boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeInt(value ? 1 : 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedBoolean, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedBoolean(channel, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public String getChannel() throws android.os.RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getChannel, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getChannel();
                    }
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }
    }

    void onReceivedString(String channel, String value) throws android.os.RemoteException;
    void onReceivedInt(String channel, int value) throws android.os.RemoteException;
    void onReceivedLong(String channel, long value) throws android.os.RemoteException;
    void onReceivedFloat(String channel, float value) throws android.os.RemoteException;
    void onReceivedDouble(String channel, double value) throws android.os.RemoteException;
    void onReceivedBoolean(String channel, boolean value) throws android.os.RemoteException;

    String getChannel() throws android.os.RemoteException;
}
