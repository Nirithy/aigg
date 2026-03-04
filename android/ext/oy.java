package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class oy implements DialogInterface.OnClickListener {
    final ow a;
    private final boolean b;
    private final boolean[] c;

    oy(ow ow0, boolean z, boolean[] arr_z) {
        this.a = ow0;
        this.b = z;
        this.c = arr_z;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        int v2 = this.b ? 0 : 0xFFFFC181;
        if(v == -1) {
            for(int v1 = 0; v1 < this.c.length; ++v1) {
                v2 = this.c[v1] ? v2 | 1 << v1 : v2 & ~(1 << v1);
            }
        }
        if(!this.b && ((1 << this.c.length) - 1 & v2) == 0) {
            v2 |= 8;
        }
        if(this.b) {
            SavedListAdapter.a(v2);
            return;
        }
        this.a.b(v2);
    }
}

