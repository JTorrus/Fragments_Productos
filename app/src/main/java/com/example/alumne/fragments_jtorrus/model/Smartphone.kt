package com.example.alumne.fragments_jtorrus.model

import android.os.Parcel
import android.os.Parcelable

class Smartphone(var name: String, var stock: Int, var img: Int): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(stock)
        parcel.writeInt(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Smartphone> {
        override fun createFromParcel(parcel: Parcel): Smartphone {
            return Smartphone(parcel)
        }

        override fun newArray(size: Int): Array<Smartphone?> {
            return arrayOfNulls(size)
        }
    }
}