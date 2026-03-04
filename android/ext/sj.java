package android.ext;

import android.widget.Toast;

class sj implements Runnable {
    private final Toast a;

    sj(Toast toast0) {
        this.a = toast0;
        super();
    }

    @Override
    public void run() {
        try {
            this.a.cancel();
        }
        catch(Throwable throwable0) {
            la.b("Toast cancel", throwable0);
        }
    }
}

