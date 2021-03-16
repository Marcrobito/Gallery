package mx.marcrobito.gallery

import android.os.Parcel
import android.os.Parcelable



class DetailParcelable(
    val id:Int,
    val largeImageURL:String,
    val user:String,
) :Parcelable {

    companion object CREATOR : Parcelable.Creator<DetailParcelable> {
        override fun createFromParcel(parcel: Parcel)= DetailParcelable (parcel)

        override fun newArray(size: Int): Array<DetailParcelable?> {
            return arrayOfNulls(size)
        }
    }

    private constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        largeImageURL = parcel.readString()?:"",
        user = parcel.readString()?:""
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(largeImageURL)
        parcel.writeString(user)
    }

    override fun describeContents() = 0
}