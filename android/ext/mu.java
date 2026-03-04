package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class mu implements DialogInterface.OnClickListener {
    final ms a;
    private final pj[][] b;
    private final int c;

    mu(ms ms0, pj[][] arr2_pj, int v) {
        this.a = ms0;
        this.b = arr2_pj;
        this.c = v;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.b[this.c][v].a(this.a.a.G);
        Tools.a(dialogInterface0);
    }
}

