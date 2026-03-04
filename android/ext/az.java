package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class az implements DialogInterface.OnClickListener {
    final ar a;

    az(ar ar0) {
        this.a = ar0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        int v1 = 1;
        qw qw0 = new qw();
        if(v != -1) {
            v1 = 2;
        }
        qw0.a("odd-vspace", v1).commit();
        if(v == -1) {
            ConfigListAdapter.c();
        }
    }
}

