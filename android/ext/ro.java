package android.ext;

import android.view.View;

class ro implements Runnable {
    final ShowApp a;

    ro(ShowApp showApp0) {
        this.a = showApp0;
        super();
    }

    @Override
    public void run() {
        rx.a().removeCallbacks(this.a.j);
        this.a.b(this.a.g);
        MainService mainService0 = MainService.instance;
        if(mainService0 != null) {
            View view0 = mainService0.e;
            if(view0 != null) {
                View view1 = mainService0.f;
                if(view1 != null && MainService.instance.p != null && this.a.a(view1, this.a.b)) {
                    this.a.h = view1;
                }
                if(this.a.a(view0, this.a.b)) {
                    this.a.g = view0;
                }
            }
        }
    }
}

