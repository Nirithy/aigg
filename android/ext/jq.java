package android.ext;

import android.os.Handler;

class jq implements Runnable {
    @Override
    public void run() {
        jp.e();
        Handler handler0 = rx.a();
        handler0.removeCallbacks(this);
        handler0.postDelayed(this, 500L);
    }
}

