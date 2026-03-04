package android.ext;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;

class bw implements Runnable {
    final bq a;
    private final AlertDialog.Builder b;

    bw(bq bq0, AlertDialog.Builder alertDialog$Builder0) {
        this.a = bq0;
        this.b = alertDialog$Builder0;
        super();
    }

    @Override
    public void run() {
        try {
            AlertDialog alertDialog0 = this.b.create();
            i.b(alertDialog0);
            Tools.a(alertDialog0);
        }
        catch(Throwable throwable0) {
            la.c("Failed show float dialog", throwable0);
        }
    }
}

