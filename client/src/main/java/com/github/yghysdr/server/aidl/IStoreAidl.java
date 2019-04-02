/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/yghysdr/androidLibrary/BinderApplication/server/src/main/aidl/com/github/yghysdr/server/aidl/IStoreAidl.aidl
 */
package com.github.yghysdr.server.aidl;
// Declare any non-default types here with import statements

public interface IStoreAidl extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements com.github.yghysdr.server.aidl.IStoreAidl {
        private static final String DESCRIPTOR = "com.github.yghysdr.server.aidl.IStoreAidl";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.github.yghysdr.server.aidl.IStoreAidl interface,
         * generating a proxy if needed.
         */
        public static com.github.yghysdr.server.aidl.IStoreAidl asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.github.yghysdr.server.aidl.IStoreAidl))) {
                return ((com.github.yghysdr.server.aidl.IStoreAidl) iin);
            }
            return new Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            String descriptor = DESCRIPTOR;
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_getApplePrice: {
                    data.enforceInterface(descriptor);
                    int _result = this.getApplePrice();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        private static class Proxy implements com.github.yghysdr.server.aidl.IStoreAidl {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public int getApplePrice() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getApplePrice, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }

        static final int TRANSACTION_getApplePrice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    public int getApplePrice() throws android.os.RemoteException;
}
