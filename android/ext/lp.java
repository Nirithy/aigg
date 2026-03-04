package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class lp implements DialogInterface.OnClickListener {
    final lo a;

    lp(lo lo0) {
        this.a = lo0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        switch(v) {
            case 0: {
                Config.a(0x7F0B009B).d();  // id:config_prevent_unload
                return;
            }
            case 1: {
                Config.a(0x7F0B0093).d();  // id:config_ram
            }
        }
    }
}

