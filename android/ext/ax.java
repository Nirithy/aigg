package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ax implements DialogInterface.OnClickListener {
    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Config.a(0x7F0B00C2).d = 0x3F0E;  // id:record_logcat
        Config.c();
        new ib(1400, true).onClick(null, 0);
    }
}

