package Model

import android.os.Parcel
import android.os.Parcelable

open class Hewan(
    var nama:String?,
    var type:String?,
    var usia:String?,
) : Parcelable {
    constructor(parcel: Parcel) :this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ){

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(nama)
        parcel.writeString(type)
        parcel.writeString(usia)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hewan>{

        override fun createFromParcel(parcel: Parcel):Hewan{
            return Hewan(parcel)
        }


        override fun newArray(size: Int): Array<Hewan?>{
            return arrayOfNulls(size)
        }
    }
    open fun makesound():String{
        return ""
    }
    open fun makefeed(type: String?):String{
        return "Anda memberi makan dengan biji bijian"
    }
    open fun makefeed(type: Int):String{
        return "Anda memberi makan dengan rumput"
    }
}
