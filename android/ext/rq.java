package android.ext;

import android.view.View;

class rq implements Runnable {
    final ShowApp a;

    rq(ShowApp showApp0) {
        this.a = showApp0;
        super();
    }

    @Override
    public void run() {
        if(this.a.a(this.a.i)) {
            this.a.i = null;
        }
        MainService mainService0 = MainService.instance;
        if(mainService0 != null) {
            View view0 = mainService0.i;
            if(this.a.a(view0, this.a.b)) {
                this.a.i = view0;
            }
        }
    }
}

