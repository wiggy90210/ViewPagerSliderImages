package com.example.viewpagersliderimagestwo.fragments

import android.os.Parcel
import android.os.Parcelable

data class FragmentData(
        val title: String?,
        val drawable: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(drawable)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FragmentData> {
        override fun createFromParcel(parcel: Parcel): FragmentData {
            return FragmentData(parcel)
        }

        override fun newArray(size: Int): Array<FragmentData?> {
            return arrayOfNulls(size)
        }
    }


}