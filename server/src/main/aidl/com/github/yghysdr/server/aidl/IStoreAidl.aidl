// IStoreAidl.aidl
package com.github.yghysdr.server.aidl;

import com.github.yghysdr.server.aidl.Apple;

interface IStoreAidl {
    int getApplePrice();

    Apple getApple();
}
