package android.ext;

import android.c.a;
import android.c.e;
import android.util.SparseIntArray;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

class of extends pj {
    int a;
    final MainService b;

    public of(MainService mainService0) {
        this.b = mainService0;
        super(0x7F0701F8, 0x7F02001E);  // string:export_selected "Export selected"
        this.a = 0;
    }

    of(MainService mainService0, int v, int v1) {
        this.b = mainService0;
        super(v, v1);
        this.a = 0;
    }

    void a() {
        this.a = 0;
        this.b();
    }

    void a(List list0, Object object0) {
        int v = list0.size();
        qx[] arr_qx = new qx[v];
        for(int v1 = 0; v1 < v; ++v1) {
            d d0 = (d)list0.get(v1);
            arr_qx[v1] = d0 instanceof qx ? ((qx)d0) : new qx(d0);
        }
        new kx(this.b.ap, arr_qx).a = true;
    }

    void b() {
        int v = 0;
        Object object0 = this.b.C();
        if(Tools.a(object0) == 0) {
            Tools.a(0x7F07013C);  // string:nothing_selected "Nothing selected"
            return;
        }
        ArrayList arrayList0 = new ArrayList();
        if(object0 instanceof boolean[]) {
            if(this.a == 0) {
                SparseIntArray sparseIntArray0 = new SparseIntArray();
                new tu(d.c(this.b.K.a(((boolean[])object0), sparseIntArray0)), sparseIntArray0, "0", qk.a(0x7F0700EF), new og(this));  // string:type_change_request "Select the data type to change"
                return;
            }
            ow ow0 = this.b.K;
            int v1 = ((boolean[])object0).length - 1;
            for(int v2 = 1; v2 < v1; ++v2) {
                if(((boolean[])object0)[v2]) {
                    Object object1 = ow0.getItem(v2);
                    if(object1 instanceof d) {
                        ((d)object1).d = this.a;
                        if(((d)object1).q()) {
                            arrayList0.add(((d)object1));
                        }
                    }
                }
            }
            this.a = 0;
        }
        else if(object0 instanceof a) {
            int v3 = ((a)object0).b();
            while(v < v3) {
                if(((a)object0).b(v)) {
                    arrayList0.add(((a)object0).a(v, null));
                }
                ++v;
            }
        }
        else if(object0 instanceof e) {
            int v4 = ((e)object0).b();
            while(v < v4) {
                if(((e)object0).d(v)) {
                    qx qx0 = (qx)((e)object0).c(v);
                    if(qx0 instanceof qx) {
                        arrayList0.add(qx0);
                    }
                }
                ++v;
            }
        }
        this.a(arrayList0, object0);
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        this.a();
    }
}

