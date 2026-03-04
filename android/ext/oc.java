package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class oc implements DialogInterface.OnClickListener {
    final ob a;
    private final long[] b;
    private final long[] c;
    private final int d;

    oc(ob ob0, long[] arr_v, long[] arr_v1, int v) {
        this.a = ob0;
        this.b = arr_v;
        this.c = arr_v1;
        this.d = v;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.a(this.b, this.c, this.d, v);
    }
}

