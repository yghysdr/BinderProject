package com.github.yghysdr.server.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @date 2019/4/2
 * @email yghysdr@163.com
 */
public class Apple implements Parcelable {

    private String id;
    private int price;

    public Apple(String id, int price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    protected Apple(Parcel in) {
        id = in.readString();
        price = in.readInt();
    }

    public static final Creator<Apple> CREATOR = new Creator<Apple>() {
        @Override
        public Apple createFromParcel(Parcel in) {
            return new Apple(in);
        }

        @Override
        public Apple[] newArray(int size) {
            return new Apple[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeInt(price);
    }
}
