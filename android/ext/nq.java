package android.ext;

import android.content.Intent;

class nq implements Runnable {
    final np a;
    private final Intent b;
    private final String c;

    nq(np np0, Intent intent0, String s) {
        this.a = np0;
        this.b = intent0;
        this.c = s;
        super();
    }

    @Override
    public void run() {
        try {
            Tools.e().startActivity(this.b);
        }
        catch(Exception exception0) {
            la.c(("Failed restart app 2: " + this.c), exception0);
        }
    }
}

