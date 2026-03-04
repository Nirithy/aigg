package android.ext;

import android.view.View;

class mh extends pj {
    final MainService a;

    mh(MainService mainService0, int v, int v1) {
        this.a = mainService0;
        super(v, v1);
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        int v = this.a.an.getCount();
        qx[] arr_qx = new qx[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_qx[v1] = this.a.an.b(v1);
        }
        new kx(this.a.ap, arr_qx);
    }
}

