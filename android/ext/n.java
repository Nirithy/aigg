package android.ext;

import android.app.AlertDialog.Builder;

class n implements Runnable {
    private final AlertDialog.Builder a;

    n(AlertDialog.Builder alertDialog$Builder0) {
        this.a = alertDialog$Builder0;
        super();
    }

    @Override
    public void run() {
        i.a(this.a, null);
    }
}

