package android.ext;

import android.os.Handler;

class ql implements Runnable {
    @Override
    public void run() {
        if(qk.c != 0L && System.currentTimeMillis() - qk.c > 5000L) {
            qk.a();
        }
        Handler handler0 = rx.a();
        try {
            handler0.removeCallbacks(this);
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
        }
        handler0.postDelayed(this, 1000L);
    }
}

