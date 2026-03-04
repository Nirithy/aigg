package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class nz implements DialogInterface.OnClickListener {
    final MainService a;

    nz(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Config.a(0x7F0B0092).d = 0;  // id:config_check_libs
        Config.c();
    }
}

