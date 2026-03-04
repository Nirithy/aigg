package android.ext;

import android.app.AlertDialog;

class bt implements Runnable {
    final bq a;
    private final AlertDialog b;

    bt(bq bq0, AlertDialog alertDialog0) {
        this.a = bq0;
        this.b = alertDialog0;
        super();
    }

    @Override
    public void run() {
        try {
            i.b(this.b);
        }
        catch(Throwable throwable0) {
            la.c(("Failed show dialog: " + this.b), throwable0);
        }
    }
}

