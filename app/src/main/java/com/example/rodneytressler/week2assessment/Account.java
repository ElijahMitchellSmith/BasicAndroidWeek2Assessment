package com.example.rodneytressler.week2assessment;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by rodneytressler on 12/14/17.
 */

public class Account implements Parcelable {
    private String name;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Account(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    protected Account(Parcel in) {
        name = in.readString();
        emailAddress = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(emailAddress);
    }

    public static final Parcelable.Creator<Account> CREATOR = new Parcelable.Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };
}
