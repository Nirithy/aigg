package android.ext;

import android.os.Handler;

class mf implements Runnable {
    final MainService a;

    mf(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        try {
            if(this.a.X == this.a.U) {
                this.a.an.d();
            }
        }
        catch(Throwable throwable0) {
            la.c("Failed update saved list", throwable0);
        }
        try {
            int v = Config.n > 0 ? Config.n : 1000;
            Handler handler0 = rx.a();
            handler0.removeCallbacks(this);
            handler0.postDelayed(this, ((long)v));
        }
        catch(Throwable throwable1) {
            la.b("Failed post timer", throwable1);
        }
    }
}

