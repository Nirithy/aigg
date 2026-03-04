package android.ext;

import android.app.AlertDialog;

class m implements Runnable {
    private final AlertDialog a;

    m(AlertDialog alertDialog0) {
        this.a = alertDialog0;
        super();
    }

    @Override
    public void run() {
        try {
            i.a(this.a);
        }
        catch(Throwable throwable0) {
            la.c("Failed show dialog on service", throwable0);
        }
    }
}

