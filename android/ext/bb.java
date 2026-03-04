package android.ext;

import android.os.Bundle;

class bb implements Runnable {
    final ar a;
    private boolean b;
    private final Bundle c;

    bb(ar ar0, Bundle bundle0) {
        this.a = ar0;
        this.c = bundle0;
        super();
        this.b = false;
    }

    @Override
    public void run() {
        la.a((this + ": 1200"));
        if(this.b) {
            la.a((this + ": already"));
            return;
        }
        this.b = true;
        this.a.c(this.c);
    }
}

