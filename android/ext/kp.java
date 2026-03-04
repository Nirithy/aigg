package android.ext;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class kp implements Parcelable.Creator {
    public ko a(Parcel parcel0) {
        return new ko(parcel0);
    }

    public ko[] a(int v) {
        return new ko[v];
    }

    @Override  // android.os.Parcelable$Creator
    public Object createFromParcel(Parcel parcel0) {
        return this.a(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public Object[] newArray(int v) {
        return this.a(v);
    }
}

