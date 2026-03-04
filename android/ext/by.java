package android.ext;

import android.app.AlertDialog.Builder;

class by implements Runnable {
    private final AlertDialog.Builder a;

    by(AlertDialog.Builder alertDialog$Builder0) {
        this.a = alertDialog$Builder0;
        super();
    }

    @Override
    public void run() {
        try {
            i.b(this.a.create());
        }
        catch(Throwable throwable0) {
            la.c("Failed show float dialog", throwable0);
        }
    }
}

