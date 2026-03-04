package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.os.Build.VERSION;

class eg implements DialogInterface.OnClickListener {
    final ConfigListAdapter a;

    eg(ConfigListAdapter configListAdapter0) {
        this.a = configListAdapter0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Tools.a(("GG: " + 101.099998f + " (" + 0x3F0E + "); Android: " + Build.VERSION.RELEASE + " (" + Build.VERSION.SDK_INT + ") [" + lh.o() + ']'), false);
    }
}

