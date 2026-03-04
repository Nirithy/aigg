package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class pq implements DialogInterface.OnClickListener {
    final OffsetCalculator a;

    pq(OffsetCalculator offsetCalculator0) {
        this.a = offsetCalculator0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        SavedListAdapter savedListAdapter0 = MainService.instance.an;
        qx qx0 = new qx(this.a.a, 0L, v);
        if(!qx0.q()) {
            qx0.d = d.a(qx0.b, true);
        }
        qx qx1 = savedListAdapter0.a(this.a.a);
        if(qx1 == null || qx1.d != qx0.d) {
            savedListAdapter0.a(qx0);
            savedListAdapter0.d();
        }
        Tools.b(Tools.a(qk.a(0x7F07013D), new Object[]{1}));  // string:items_added "Items (__d__) added to the saved list"
    }
}

