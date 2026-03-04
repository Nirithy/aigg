package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface;

class co extends cz {
    private int k;

    co(int v, int v1, int[] arr_v, int v2, String s, boolean z, int v3) {
        super(v, v1, arr_v, v2, s, z, v3);
        this.k = 0;
    }

    @Override  // android.ext.cz
    public boolean a(DialogInterface dialogInterface0, int v) {
        boolean z = false;
        if(v >= 0) {
            this.k = this.d;
            z = super.a(dialogInterface0, v);
            if(z && v == 1) {
                AlertDialog alertDialog0 = i.a(Tools.e()).setCustomTitle(Tools.d(this.a)).setMessage(qk.a(this.h)).setPositiveButton(0x7F07008C, this).setNegativeButton(0x7F0700A1, this).create();  // string:save "Save"
                i.c(alertDialog0);
                i.a(alertDialog0, new cp(this, alertDialog0));
                return z;
            }
        }
        else if(v == -2) {
            this.d = 0;
            Config.c();
            return false;
        }
        return z;
    }
}

