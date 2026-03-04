package android.ext;

import android.fix.j;
import android.util.SparseIntArray;
import android.view.View;

class op extends pj {
    int a;
    final MainService b;

    public op(MainService mainService0) {
        this.b = mainService0;
        super(0x7F070144, 0x7F020052);  // string:revert_selected "Revert selected"
        this.a = 0;
    }

    void a() {
        Object object0 = this.b.C();
        g g0 = new g();
        g g1 = this.b.ao;
        h h0 = new h();
        if(!(object0 instanceof boolean[])) {
            this.b.a(object0, g0);
        }
        else if(this.a == 0) {
            SparseIntArray sparseIntArray0 = new SparseIntArray();
            j j0 = d.c(this.b.K.a(((boolean[])object0), sparseIntArray0));
            if(sparseIntArray0.size() > 0) {
                new tu(j0, sparseIntArray0, "0", qk.a(0x7F0700EF), new oq(this));  // string:type_change_request "Select the data type to change"
                return;
            }
        }
        else {
            ow ow0 = this.b.K;
            int v = ((boolean[])object0).length - 1;
            for(int v1 = 1; v1 < v; ++v1) {
                if(((boolean[])object0)[v1]) {
                    d d0 = new d(ow0.a(v1), 0L, this.a);
                    if(d0.q()) {
                        g1.a(d0.b, d0.d, h0);
                        if(h0.b) {
                            g0.a(d0.b, d0.d, h0.a);
                        }
                    }
                }
            }
            this.a = 0;
        }
        int v2 = g0.b();
        if(v2 == 0) {
            Tools.a(0x7F070145);  // string:nothing_to_revert "Nothing to revert"
            return;
        }
        i.a(i.c().setCustomTitle(Tools.d(0x7F070144)).setMessage(Tools.a(qk.a(0x7F070146), new Object[]{v2})).setPositiveButton(qk.a(0x7F07009B), new or(this, g0)).setNegativeButton(qk.a(0x7F07009C), null));  // string:revert_selected "Revert selected"
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        this.a = 0;
        this.a();
    }
}

