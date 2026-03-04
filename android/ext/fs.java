package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class fs implements DialogInterface.OnClickListener {
    final fr a;

    fs(fr fr0) {
        this.a = fr0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Config.a(0x7F0B0087).d = 0;  // id:config_hide_from_game
        Config.c();
    }
}

