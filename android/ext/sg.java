package android.ext;

import android.widget.Toast;

class sg implements Runnable {
    @Override
    public void run() {
        Toast toast0;
        try {
            Thread.sleep(3000L);
        }
        catch(Throwable throwable0) {
            la.c("toastThread", throwable0);
        }
        while(!Thread.currentThread().isInterrupted()) {
            try {
                Object object0 = sf.b;
                synchronized(object0) {
                    toast0 = sf.a;
                    sf.a = null;
                }
                if((Config.B & 0x2000) != 0) {
                    rx.a(new sh(this));
                }
                sf.e(toast0);
                Thread.sleep(1500L);
            }
            catch(Throwable throwable1) {
                la.c("toastThread", throwable1);
            }
        }
    }
}

