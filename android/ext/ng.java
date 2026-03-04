package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ng implements DialogInterface.OnClickListener {
    final MainService a;

    ng(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Config.a(0x7F0B0097).d = 1;  // id:config_waitpid
        Config.c();
        ConfigListAdapter.c();
    }
}

