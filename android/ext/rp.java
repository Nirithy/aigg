package android.ext;

import android.view.View;

class rp implements Runnable {
    final ShowApp a;

    rp(ShowApp showApp0) {
        this.a = showApp0;
        super();
    }

    @Override
    public void run() {
        View view0 = this.a.g;
        if(view0 != null && (MainService.instance.e == null || MainService.instance.p == null)) {
            this.a.b(view0);
        }
    }
}

