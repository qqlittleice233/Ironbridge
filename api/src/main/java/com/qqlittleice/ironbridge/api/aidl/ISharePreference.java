package com.qqlittleice.ironbridge.api.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Keep;

import com.qqlittleice.ironbridge.api.annotation.BridgeVersion;

@Keep
public interface ISharePreference extends IInterface {

    @Keep
    abstract class Stub extends Binder implements ISharePreference {
        private static final String DESCRIPTOR = "com.qqlittleice.ironbridge.api.aidl.ISharePreference";
        private static final int api = 2;

        static final int TRANSACTION_addCallback = IBinder.FIRST_CALL_TRANSACTION;
        static final int TRANSACTION_removeCallback = IBinder.FIRST_CALL_TRANSACTION + 1;
        static final int TRANSACTION_setString = IBinder.FIRST_CALL_TRANSACTION + 2;
        static final int TRANSACTION_setStringArray = IBinder.FIRST_CALL_TRANSACTION + 3;
        static final int TRANSACTION_setInt = IBinder.FIRST_CALL_TRANSACTION + 4;
        static final int TRANSACTION_setLong = IBinder.FIRST_CALL_TRANSACTION + 5;
        static final int TRANSACTION_setFloat = IBinder.FIRST_CALL_TRANSACTION + 6;
        static final int TRANSACTION_setBoolean = IBinder.FIRST_CALL_TRANSACTION + 7;
        static final int TRANSACTION_setDouble = IBinder.FIRST_CALL_TRANSACTION + 8;
        static final int TRANSACTION_getString = IBinder.FIRST_CALL_TRANSACTION + 9;
        static final int TRANSACTION_getStringArray = IBinder.FIRST_CALL_TRANSACTION + 10;
        static final int TRANSACTION_getInt = IBinder.FIRST_CALL_TRANSACTION + 11;
        static final int TRANSACTION_getLong = IBinder.FIRST_CALL_TRANSACTION + 12;
        static final int TRANSACTION_getFloat = IBinder.FIRST_CALL_TRANSACTION + 13;
        static final int TRANSACTION_getBoolean = IBinder.FIRST_CALL_TRANSACTION + 14;
        static final int TRANSACTION_getDouble = IBinder.FIRST_CALL_TRANSACTION + 15;
        static final int TRANSACTION_setScope = IBinder.FIRST_CALL_TRANSACTION + 16;

        static final int TRANSACTION_API = IBinder.LAST_CALL_TRANSACTION;

        public Stub() { attachInterface(this, DESCRIPTOR); }

        public static ISharePreference asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface localInterface = obj.queryLocalInterface(DESCRIPTOR);
            if ((localInterface instanceof ISharePreference)) {
                return (ISharePreference) localInterface;
            }
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() { return this; }

        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = DESCRIPTOR;
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_addCallback: {
                    data.enforceInterface(descriptor);
                    ISharePreferenceCallback callback = ISharePreferenceCallback.Stub.asInterface(data.readStrongBinder());
                    addCallback(callback);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_removeCallback: {
                    data.enforceInterface(descriptor);
                    ISharePreferenceCallback callback = ISharePreferenceCallback.Stub.asInterface(data.readStrongBinder());
                    removeCallback(callback);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setString: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    String value = data.readString();
                    setString(key, value);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setStringArray: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    String[] values = data.createStringArray();
                    setStringArray(key, values);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setInt: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    int value = data.readInt();
                    setInt(key, value);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setLong: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    long value = data.readLong();
                    setLong(key, value);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setFloat: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    float value = data.readFloat();
                    setFloat(key, value);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setBoolean: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    boolean value = data.readInt() != 0;
                    setBoolean(key, value);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_API: {
                    data.enforceInterface(descriptor);
                    reply.writeNoException();
                    reply.writeInt(api);
                    return true;
                }
                case TRANSACTION_setDouble: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    double value = data.readDouble();
                    setDouble(key, value);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getString: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    String defValue = data.readString();
                    String result = getString(key, defValue);
                    reply.writeNoException();
                    reply.writeString(result);
                    return true;
                }
                case TRANSACTION_getStringArray: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    String[] defValue = data.createStringArray();
                    String[] result = getStringArray(key, defValue);
                    reply.writeNoException();
                    reply.writeStringArray(result);
                    return true;
                }
                case TRANSACTION_getInt: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    int defValue = data.readInt();
                    int result = getInt(key, defValue);
                    reply.writeNoException();
                    reply.writeInt(result);
                    return true;
                }
                case TRANSACTION_getLong: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    long defValue = data.readLong();
                    long result = getLong(key, defValue);
                    reply.writeNoException();
                    reply.writeLong(result);
                    return true;
                }
                case TRANSACTION_getFloat: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    float defValue = data.readFloat();
                    float result = getFloat(key, defValue);
                    reply.writeNoException();
                    reply.writeFloat(result);
                    return true;
                }
                case TRANSACTION_getBoolean: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    boolean defValue = data.readInt() != 0;
                    boolean result = getBoolean(key, defValue);
                    reply.writeNoException();
                    reply.writeInt(result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_getDouble: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    double defValue = data.readDouble();
                    double result = getDouble(key, defValue);
                    reply.writeNoException();
                    reply.writeDouble(result);
                    return true;
                }
                case TRANSACTION_setScope: {
                    data.enforceInterface(descriptor);
                    String[] scope = data.createStringArray();
                    setScope(scope);
                    reply.writeNoException();
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        public static ISharePreference getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Keep
        private static class Proxy implements ISharePreference {

            private final IBinder mRemote;
            public static ISharePreference sDefaultImpl;

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

            public int getRemoteApiVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(TRANSACTION_API, _data, _reply, 0);
                    if (!_status) {
                        Log.d("IronBridge-ISharePreference", "get remote api version failed");
                        return 0;
                    }
                    _reply.readException();
                    return _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean checkApiVersion(int requireApi) throws RemoteException {
                int remoteApi = getRemoteApiVersion();
                return remoteApi >= requireApi;
            }

            @Override
            public void setScope(String[] scope) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStringArray(scope);
                    boolean _status = mRemote.transact(TRANSACTION_setScope, _data, _reply, 0);
                    _reply.readException();
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().setScope(scope);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void addCallback(ISharePreferenceCallback callback) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                   boolean _status = mRemote.transact(TRANSACTION_addCallback, _data, _reply, IBinder.FLAG_ONEWAY);
                   _reply.readException();
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().addCallback(callback);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void removeCallback(ISharePreferenceCallback callback) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    boolean _status = mRemote.transact(TRANSACTION_removeCallback, _data, _reply, IBinder.FLAG_ONEWAY);
                    _reply.readException();
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().removeCallback(callback);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setString(String key, String value) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeString(value);
                    boolean _status = mRemote.transact(TRANSACTION_setString, _data, _reply, IBinder.FLAG_ONEWAY);
                    _reply.readException();
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().setString(key, value);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setStringArray(String key, String[] values) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeStringArray(values);
                    boolean _status = mRemote.transact(TRANSACTION_setStringArray, _data, _reply, IBinder.FLAG_ONEWAY);
                    _reply.readException();
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().setStringArray(key, values);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setInt(String key, int value) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeInt(value);
                    boolean _status = mRemote.transact(TRANSACTION_setInt, _data, _reply, IBinder.FLAG_ONEWAY);
                    _reply.readException();
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().setInt(key, value);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setDouble(String key, double value) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeDouble(value);
                    boolean _status = mRemote.transact(TRANSACTION_setDouble, _data, _reply, IBinder.FLAG_ONEWAY);
                    _reply.readException();
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().setDouble(key, value);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setLong(String key, long value) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeLong(value);
                    boolean _status = mRemote.transact(TRANSACTION_setLong, _data, _reply, IBinder.FLAG_ONEWAY);
                    _reply.readException();
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().setLong(key, value);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setFloat(String key, float value) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeFloat(value);
                    boolean _status = mRemote.transact(TRANSACTION_setFloat, _data, _reply, IBinder.FLAG_ONEWAY);
                    _reply.readException();
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().setFloat(key, value);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setBoolean(String key, boolean value) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeInt(value ? 1 : 0);
                    boolean _status = mRemote.transact(TRANSACTION_setBoolean, _data, _reply, IBinder.FLAG_ONEWAY);
                    _reply.readException();
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().setBoolean(key, value);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public String getString(String key, String defValue) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return null;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeString(defValue);
                    mRemote.transact(TRANSACTION_getString, _data, _reply, 0);
                    _reply.readException();
                    return _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public String[] getStringArray(String key, String[] defValue) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return null;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeStringArray(defValue);
                    mRemote.transact(TRANSACTION_getStringArray, _data, _reply, 0);
                    _reply.readException();
                    return _reply.createStringArray();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getInt(String key, int defValue) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return Integer.MAX_VALUE;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeInt(defValue);
                    mRemote.transact(TRANSACTION_getInt, _data, _reply, 0);
                    _reply.readException();
                    return _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public double getDouble(String key, double defValue) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return Double.MAX_VALUE;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeDouble(defValue);
                    mRemote.transact(TRANSACTION_getDouble, _data, _reply, 0);
                    _reply.readException();
                    return _reply.readDouble();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public long getLong(String key, long defValue) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return Long.MAX_VALUE;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeLong(defValue);
                    mRemote.transact(TRANSACTION_getLong, _data, _reply, 0);
                    _reply.readException();
                    return _reply.readLong();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public float getFloat(String key, float defValue) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return Float.MAX_VALUE;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeFloat(defValue);
                    mRemote.transact(TRANSACTION_getFloat, _data, _reply, 0);
                    _reply.readException();
                    return _reply.readFloat();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean getBoolean(String key, boolean defValue) throws RemoteException {
                if (!checkApiVersion(2)) {
                    Log.d("IronBridge-ISharePreference", "remote api version is too low, require 2");
                    return false;
                }
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeInt(defValue ? 1 : 0);
                    mRemote.transact(TRANSACTION_getBoolean, _data, _reply, 0);
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }

    @BridgeVersion(2)
    void setScope(String[] scope) throws RemoteException, SecurityException;

    @BridgeVersion(2)
    void addCallback(ISharePreferenceCallback callback) throws RemoteException;
    @BridgeVersion(2)
    void removeCallback(ISharePreferenceCallback callback) throws RemoteException;
    @BridgeVersion(2)
    void setString(String key, String value) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    void setStringArray(String key, String[] values) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    void setInt(String key, int value) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    void setDouble(String key, double value) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    void setLong(String key, long value) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    void setFloat(String key, float value) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    void setBoolean(String key, boolean value) throws RemoteException, SecurityException;

    @BridgeVersion(2)
    String getString(String key, String defValue) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    String[] getStringArray(String key, String[] defValue) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    int getInt(String key, int defValue) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    double getDouble(String key, double defValue) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    long getLong(String key, long defValue) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    float getFloat(String key, float defValue) throws RemoteException, SecurityException;
    @BridgeVersion(2)
    boolean getBoolean(String key, boolean defValue) throws RemoteException, SecurityException;

}
