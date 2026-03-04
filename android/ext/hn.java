package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class hn implements DialogInterface.OnClickListener {
    final hk a;
    private final d b;

    hn(hk hk0, d d0) {
        this.a = hk0;
        this.b = d0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.b.d = v;
        this.a.a(this.b);
    }
}

