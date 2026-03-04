package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class dl implements DialogInterface.OnClickListener {
    final dk a;
    private final boolean[] b;
    private final int c;

    dl(dk dk0, boolean[] arr_z, int v) {
        this.a = dk0;
        this.b = arr_z;
        this.c = v;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        long v1 = -1L;
        if(v == -3 || v == -1) {
            if(v == -1) {
                for(int v2 = 0; v2 < this.b.length; ++v2) {
                    v1 = this.b[v2] ? v1 | ((long)(1 << v2)) : v1 & ((long)(~(1 << v2)));
                }
            }
            if((((long)((1 << this.b.length) - 1)) & v1) == 0L) {
                v1 |= 1L;
            }
            Config.b[this.c] = v1;
            Config.c();
        }
        ConfigListAdapter.f();
    }
}

