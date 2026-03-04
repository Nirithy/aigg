package android.ext;

import android.content.DialogInterface;

class cm extends cz {
    cm(int v, int v1, int[] arr_v, int v2, String s, boolean z) {
        super(v, v1, arr_v, v2, s, z);
    }

    @Override  // android.ext.cz
    public boolean a(DialogInterface dialogInterface0, int v) {
        boolean z = super.a(dialogInterface0, v);
        if(z) {
            MainService.instance.l.m();
        }
        return z;
    }
}

