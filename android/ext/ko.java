package android.ext;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class ko implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    boolean a;
    int b;
    String c;
    String d;
    String e;
    boolean f;
    int g;
    String h;

    static {
        ko.CREATOR = new kp();
    }

    ko() {
        this.a = false;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = 0;
        this.h = "";
    }

    protected ko(Parcel parcel0) {
        boolean z = true;
        super();
        this.a = false;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = 0;
        this.h = "";
        this.a = parcel0.readByte() != 0;
        this.b = parcel0.readInt();
        this.c = parcel0.readString();
        this.d = parcel0.readString();
        this.e = parcel0.readString();
        if(parcel0.readByte() == 0) {
            z = false;
        }
        this.f = z;
        this.g = parcel0.readInt();
        this.h = parcel0.readString();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = 1;
        parcel0.writeByte(((byte)(this.a ? 1 : 0)));
        parcel0.writeInt(this.b);
        parcel0.writeString(this.c);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        if(!this.f) {
            v1 = 0;
        }
        parcel0.writeByte(((byte)v1));
        parcel0.writeInt(this.g);
        parcel0.writeString(this.h);
    }
}

