package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

public class ib implements DialogInterface.OnClickListener {
    private boolean a;
    private final int b;

    public ib(int v) {
        this(v, false);
    }

    public ib(int v, boolean z) {
        this.b = v;
        this.a = z;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        la.a(("ExitListener called: " + this.b));
        lh.c = this.a ? 1 : 0;
        lh.j();
    }
}

