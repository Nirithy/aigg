package android.ext;

import android.content.DialogInterface;

class dq implements cu {
    final ConfigListAdapter a;

    dq(ConfigListAdapter configListAdapter0) {
        this.a = configListAdapter0;
        super();
    }

    @Override  // android.ext.cu
    public int a(DialogInterface dialogInterface0, int v) {
        if(v == 1 && !InternalKeyboard.c()) {
            v = 0;
            MainService.H();
        }
        return v;
    }
}

