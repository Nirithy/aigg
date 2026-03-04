package android.ext;

import android.c.a;
import android.util.SparseIntArray;
import android.view.View;
import java.util.ArrayList;

class os extends pj {
    final MainService a;

    public os(MainService mainService0) {
        this.a = mainService0;
        super(0x7F07013B, 0x7F020018);  // string:save_selected "Save selected"
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        Object object0 = this.a.C();
        int v = Tools.a(object0);
        if(v == 0) {
            Tools.a(0x7F07013C);  // string:nothing_selected "Nothing selected"
            return;
        }
        if(object0 instanceof boolean[]) {
            SparseIntArray sparseIntArray0 = new SparseIntArray();
            new tu(d.c(this.a.K.a(((boolean[])object0), sparseIntArray0)), sparseIntArray0, "0", qk.a(0x7F0700EF), new ot(this, object0, v));  // string:type_change_request "Select the data type to change"
            return;
        }
        if(object0 instanceof a) {
            ArrayList arrayList0 = new ArrayList();
            int v1 = ((a)object0).b();
            for(int v2 = 0; v2 < v1; ++v2) {
                if(((a)object0).b(v2)) {
                    arrayList0.add(((a)object0).a(v2, null));
                }
            }
            for(Object object1: arrayList0) {
                d d0 = (d)object1;
                qx qx0 = this.a.an.a(d0.b);
                if(qx0 == null || qx0.d != d0.d) {
                    this.a.an.a(new qx(d0), 0, false);
                }
            }
            this.a.an.notifyDataSetChanged();
            this.a.an.d();
            Tools.b(Tools.a(qk.a(0x7F07013D), new Object[]{v}));  // string:items_added "Items (__d__) added to the saved list"
            qm qm0 = MainService.instance.h;
            if(qm0 != null) {
                qm0.write("\nlocal t = ");
                ek.a(qm0, true);
                qm0.write("gg.addListItems(t)\n");
                qm0.write("t = nil\n\n");
            }
        }
    }
}

