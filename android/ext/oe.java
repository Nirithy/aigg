package android.ext;

import android.view.View;

class oe extends pj {
    final MainService a;

    public oe(MainService mainService0) {
        this.a = mainService0;
        super(0x7F070136, 0x7F02004A);  // string:clear_selection "Clear selection"
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        this.a.d(0);
    }
}

