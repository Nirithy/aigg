package android.ext;

import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;

class nn implements DialogInterface.OnDismissListener {
    final nl a;
    private final String b;
    private final boolean c;

    nn(nl nl0, String s, boolean z) {
        this.a = nl0;
        this.b = s;
        this.c = z;
        super();
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        this.a.a.a(this.b, this.c);
    }
}

