package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ot implements DialogInterface.OnClickListener {
    final os a;
    private final Object b;
    private final int c;

    ot(os os0, Object object0, int v) {
        this.a = os0;
        this.b = object0;
        this.c = v;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        ow ow0 = this.a.a.K;
        boolean[] arr_z = (boolean[])this.b;
        int v1 = arr_z.length - 1;
        for(int v2 = 1; v2 < v1; ++v2) {
            if(arr_z[v2]) {
                long v3 = ow0.a(v2);
                qx qx0 = new qx(v3, 0L, v);
                if(!qx0.q()) {
                    qx0.d = d.a(qx0.b, true);
                }
                qx qx1 = this.a.a.an.a(v3);
                if(qx1 == null || qx1.d != qx0.d) {
                    this.a.a.an.a(qx0, 0, false);
                }
            }
        }
        this.a.a.an.notifyDataSetChanged();
        this.a.a.an.d();
        Tools.b(Tools.a(qk.a(0x7F07013D), new Object[]{this.c}));  // string:items_added "Items (__d__) added to the saved list"
    }
}

