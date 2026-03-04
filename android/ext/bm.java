package android.ext;

import android.app.AlertDialog;

class bm implements Runnable {
    final bl a;

    bm(bl bl0) {
        this.a = bl0;
        super();
    }

    @Override
    public void run() {
        AlertDialog alertDialog0 = this.a.a;
        if(alertDialog0 != null) {
            i.c(alertDialog0);
        }
    }
}

