package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ub implements DialogInterface.OnClickListener {
    private final Runnable a;
    private final String b;

    ub(Runnable runnable0, String s) {
        this.a = runnable0;
        this.b = s;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        la.a((this.a + ": 120"));
        ty.a(this.b);
        la.a((this.a + ": 130"));
    }
}

