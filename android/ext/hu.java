package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class hu implements DialogInterface.OnClickListener {
    private final String[] a;
    private final int b;

    hu(String[] arr_s, int v) {
        this.a = arr_s;
        this.b = v;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Tools.h(this.a[this.b * 2 + 1]);
    }
}

