package com.example.startactivityforresult_sending_and_receiving_data_parcelable_kotlin.model

import android.os.Parcel
import android.os.Parcelable

class User(val name: String?, val age:Int, val gender:Char):Parcelable{

    override fun toString(): String {
        return "User(name='$name', age=$age, gender=$gender)"
    }

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt().toChar()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeInt(gender.toInt())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}