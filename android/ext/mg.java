package android.ext;

import android.view.View;

class mg extends pj {
    final MainService a;

    mg(MainService mainService0, int v, int v1) {
        this.a = mainService0;
        super(v, v1);
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        new kx(this.a.ap, null);
    }
}

