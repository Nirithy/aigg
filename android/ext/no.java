package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class no implements DialogInterface.OnClickListener {
    final nl a;
    private final String b;
    private final boolean c;

    no(nl nl0, String s, boolean z) {
        this.a = nl0;
        this.b = s;
        this.c = z;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        rx.b(new np(this, this.b, this.c));
    }
}

