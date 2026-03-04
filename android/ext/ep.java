package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ep implements DialogInterface.OnClickListener {
    final eo a;
    private final boolean[] b;

    ep(eo eo0, boolean[] arr_z) {
        this.a = eo0;
        this.b = arr_z;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            int v1 = 0;
            int v2;
            for(v2 = 0; v1 < this.b.length; v2 = v3) {
                int v3 = this.b[v1] ? 1 << v1 | v2 : ~(1 << v1) & v2;
                ++v1;
            }
        }
        else {
            v2 = 0;
        }
        Config.a(0x7F0B00C1).d = v2;  // id:config_copy_params
        Config.c();
        this.a.a(v2);
    }
}

