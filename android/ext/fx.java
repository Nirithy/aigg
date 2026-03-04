package android.ext;

import android.os.Handler;

class fx implements Runnable {
    final ex a;

    fx(ex ex0) {
        this.a = ex0;
        super();
    }

    @Override
    public void run() {
        Handler handler0 = rx.b();
        handler0.removeCallbacks(this);
        if(this.a.c()) {
            handler0.postDelayed(this, 1000L);
        }
    }
}

