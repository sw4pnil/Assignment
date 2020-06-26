package com.test.assignment.models

import android.os.Parcel
import android.os.Parcelable

/**
 * @author swapnil-tml on 26-06-2020.
 * Country category data to show
 */


class Country() : Parcelable {

    private var title: String? = null
    private var description: String? = null
    private var imageHref: String? = null
    private var rank: Int? = null


    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getImageHref(): String? {
        return imageHref
    }

    fun setImageHref(imageHref: String?) {
        this.imageHref = imageHref
    }

    fun getRank(): Int? {
        return rank
    }

    fun setRank(rank: Int?) {
        this.rank = rank
    }


    fun Country(title: String?, description: String?, imageHref: String?) {
        this.title = title
        this.description = description
        this.imageHref = imageHref

    }

    fun Country() {}

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        description = parcel.readString()
        imageHref = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(imageHref)

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Country(title=$title, description=$description, imageHref=$imageHref)"
    }

    companion object CREATOR : Parcelable.Creator<Country> {
        override fun createFromParcel(parcel: Parcel): Country {
            return Country(parcel)
        }

        override fun newArray(size: Int): Array<Country?> {
            return arrayOfNulls(size)
        }
    }
}