package android.ext;

import android.content.DialogInterface;

class ed implements cu {
    final ConfigListAdapter a;

    ed(ConfigListAdapter configListAdapter0) {
        this.a = configListAdapter0;
        super();
    }

    @Override  // android.ext.cu
    public int a(DialogInterface dialogInterface0, int v) {
        if(v != Config.o) {
            ConfigListAdapter.c();
        }
        return v;
    }
}

