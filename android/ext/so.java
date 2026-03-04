package android.ext;

import android.app.AlertDialog;

class so implements Runnable {
    private final AlertDialog a;

    so(AlertDialog alertDialog0) {
        this.a = alertDialog0;
        super();
    }

    @Override
    public void run() {
        try {
            Tools.b(this.a.getWindow());
        }
        catch(Throwable throwable0) {
            la.c("hideSoftInputFromWindow", throwable0);
        }
    }
}

