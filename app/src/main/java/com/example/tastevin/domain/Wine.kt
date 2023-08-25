package com.example.tastevin.domain

import android.os.Parcel
import android.os.Parcelable
import com.example.tastevin.database.entity.RoomWine

data class Wine(
    val id: Int,
    val nameKr: String?,
    val nameEn: String?,
    val producer: String,
    val nation: String,
    val type: String,
    val sweet: Int,
    val acidity: Int,
    val body: Int,
    val tannin: Int,
    val price: String?,
    val food: String,
    val url: String,
    val count: Int,
    val recommend1: Int? = null,
    val recommend2: Int? = null,
    val recommend3: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Wine> {
        override fun createFromParcel(parcel: Parcel): Wine {
            return Wine(parcel)
        }

        override fun newArray(size: Int): Array<Wine?> {
            return arrayOfNulls(size)
        }
    }
}

fun Wine.asDatabaseModel(): RoomWine {
    return RoomWine(
        id = id,
        nameKr = nameKr,
        nameEn = nameEn,
        producer = producer,
        nation = nation,
        type = type,
        sweet = sweet,
        acidity = acidity,
        body = body,
        tannin = tannin,
        price = price,
        food = food,
        url = url,
        count = count
    )
}