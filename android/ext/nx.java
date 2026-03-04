package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class nx implements DialogInterface.OnClickListener {
    final nw a;
    private final String b;

    nx(nw nw0, String s) {
        this.a = nw0;
        this.b = s;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Tools.a(0x7F07033E, 0);  // string:reinstall_started "Reinstallation started..."
        new hx(new ny(this, this.b), "FixLibs").start();
    }
}

