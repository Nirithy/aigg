package android.ext;

import android.view.View;

class ou extends pj {
    final MainService a;

    public ou(MainService mainService0) {
        this.a = mainService0;
        super(0x7F070138, 0x7F020048);  // string:select_all "Select all"
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        this.a.d(1);
    }
}

