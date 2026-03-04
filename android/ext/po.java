package android.ext;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;

class po implements Runnable {
    final pl a;
    private final AlertDialog.Builder b;

    po(pl pl0, AlertDialog.Builder alertDialog$Builder0) {
        this.a = pl0;
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
            la.c("Failed show miui dialog", throwable0);
        }
    }
}

