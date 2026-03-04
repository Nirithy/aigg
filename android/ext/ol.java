package android.ext;

import android.view.View;

class ol extends pj {
    final boolean a;
    final MainService b;

    public ol(MainService mainService0, boolean z) {
        this.b = mainService0;
        super(0x7F070192, 0x7F02001B);  // string:remove "Remove"
        this.a = z;
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        Object object0 = this.b.C();
        int v = Tools.a(object0);
        String s = " (" + v + ')';
        String[] arr_s = {qk.a(0x7F0702CD), "---", qk.a(0x7F070191) + s, qk.a(0x7F070192) + s};  // string:remove_all2 "Remove all"
        i.a(i.c().setItems(arr_s, new om(this, v, object0)).setNegativeButton(qk.a(0x7F0700A1), null));  // string:cancel "Cancel"
    }
}

