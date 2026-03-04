package android.ext;

import android.app.AlertDialog;
import java.lang.ref.WeakReference;

class p {
    public WeakReference a;
    public WeakReference b;

    public p(AlertDialog alertDialog0, q q0) {
        this.a = new WeakReference(alertDialog0);
        this.b = new WeakReference(q0);
    }
}

