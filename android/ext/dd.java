package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class dd implements DialogInterface.OnClickListener {
    final ConfigListAdapter a;

    dd(ConfigListAdapter configListAdapter0) {
        this.a = configListAdapter0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Config.c = 0L;
        Config.c();
    }
}

