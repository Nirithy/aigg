package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

public abstract class ct implements DialogInterface.OnClickListener {
    int a;
    int b;
    String c;
    int d;
    boolean e;
    int f;
    boolean g;
    int h;
    protected cu i;
    protected cv j;

    public ct(int v, int v1, int v2, String s, boolean z) {
        this.f = 0;
        this.a = v1;
        this.b = v2;
        this.c = s;
        this.d = v2;
        this.g = z;
        this.h = -1;
        this.i = null;
        this.a();
        Config.H.put(v, this);
    }

    protected void a() {
    }

    public void a(cu cu0) {
        this.i = cu0;
    }

    public void a(cv cv0) {
        this.j = cv0;
    }

    public abstract boolean a(DialogInterface arg1, int arg2);

    public CharSequence c() {
        return this.toString();
    }

    public abstract void d();

    public long e() {
        return ((long)this.d) | ((long)this.f) << 0x20;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        cu cu0 = this.i;
        if(cu0 != null) {
            v = cu0.a(dialogInterface0, v);
        }
        if(this.a(dialogInterface0, v)) {
            cv cv0 = this.j;
            if(cv0 != null) {
                cv0.a(this.d);
            }
        }
    }

    @Override
    public String toString() {
        return qk.a(this.a) + ' ' + this.d;
    }
}

