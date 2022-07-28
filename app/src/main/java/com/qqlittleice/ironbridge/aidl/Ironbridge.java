package com.qqlittleice.ironbridge.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface Ironbridge extends IInterface {

    class Default implements Ironbridge {
        @Override
        public void addListener(BridgeListener listener) {}
        @Override
        public void removeListener(BridgeListener listener) {}
        @Override
        public void sendString(String tag, String value) {}
        @Override
        public void sendInt(String tag, int value) {}
        @Override
        public void sendLong(String tag, long value) {}
        @Override
        public void sendFloat(String tag, float value) {}
        @Override
        public void sendDouble(String tag, double value) {}
        @Override
        public void sendBoolean(String tag, boolean value) {}
        @Override
        public IBinder asBinder() { return null; }
    }

    abstract class Stub extends Binder implements Ironbridge {

        private static final String DESCRIPTOR = "com.qqlittleice.ironbridge.aidl.Ironbridge";

        static final int TRANSACTION_addListener = IBinder.FIRST_CALL_TRANSACTION;
        static final int TRANSACTION_removeListener = IBinder.FIRST_CALL_TRANSACTION + 1;
        static final int TRANSACTION_sendString = IBinder.FIRST_CALL_TRANSACTION + 2;
        static final int TRANSACTION_sendInt = IBinder.FIRST_CALL_TRANSACTION + 3;
        static final int TRANSACTION_sendLong = IBinder.FIRST_CALL_TRANSACTION + 4;
        static final int TRANSACTION_sendFloat = IBinder.FIRST_CALL_TRANSACTION + 5;
        static final int TRANSACTION_sendDouble = IBinder.FIRST_CALL_TRANSACTION + 6;
        static final int TRANSACTION_sendBoolean = IBinder.FIRST_CALL_TRANSACTION + 7;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static Ironbridge asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface localInterface = obj.queryLocalInterface(DESCRIPTOR);
            if ((localInterface instanceof Ironbridge)) {
                return (Ironbridge) localInterface;
            }
            return new Ironbridge.Stub.Proxy(obj);
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
                case TRANSACTION_addListener: {
                    data.enforceInterface(descriptor);
                    BridgeListener listener = BridgeListener.Stub.asInterface(data.readStrongBinder());
                    this.addListener(listener);
                    return true;
                }
                case TRANSACTION_removeListener: {
                    data.enforceInterface(descriptor);
                    BridgeListener listener = BridgeListener.Stub.asInterface(data.readStrongBinder());
                    this.removeListener(listener);
                    return true;
                }
                case TRANSACTION_sendString: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    String value = data.readString();
                    sendString(tag, value);
                    return true;
                }
                case TRANSACTION_sendInt: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    int value = data.readInt();
                    sendInt(tag, value);
                    return true;
                }
                case TRANSACTION_sendLong: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    long value = data.readLong();
                    sendLong(tag, value);
                    return true;
                }
                case TRANSACTION_sendFloat: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    float value = data.readFloat();
                    sendFloat(tag, value);
                    return true;
                }
                case TRANSACTION_sendDouble: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    double value = data.readDouble();
                    sendDouble(tag, value);
                    return true;
                }
                case TRANSACTION_sendBoolean: {
                    data.enforceInterface(descriptor);
                    String tag = data.readString();
                    boolean value = data.readInt() != 0;
                    sendBoolean(tag, value);
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        public static boolean setDefaultImpl(Ironbridge impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static Ironbridge getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        private static class Proxy implements Ironbridge {

            private final IBinder mRemote;
            public static Ironbridge sDefaultImpl;

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
            public void addListener(BridgeListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_addListener, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().addListener(listener);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void removeListener(BridgeListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_removeListener, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().removeListener(listener);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendString(String tag, String value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeString(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendString, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendString(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendInt(String tag, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeInt(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendInt, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendInt(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendLong(String tag, long value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeLong(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendLong, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendLong(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendFloat(String tag, float value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeFloat(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendFloat, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendFloat(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendDouble(String tag, double value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeDouble(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendDouble, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendDouble(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendBoolean(String tag, boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(tag);
                    _data.writeInt(value ? 1 : 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendBoolean, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendBoolean(tag, value);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }
    }

    void addListener(BridgeListener listener) throws RemoteException;
    void removeListener(BridgeListener listener) throws RemoteException;
    void sendString(String tag, String value) throws RemoteException;
    void sendInt(String tag, int value) throws RemoteException;
    void sendLong(String tag, long value) throws RemoteException;
    void sendFloat(String tag, float value) throws RemoteException;
    void sendDouble(String tag, double value) throws RemoteException;
    void sendBoolean(String tag, boolean value) throws RemoteException;

}
