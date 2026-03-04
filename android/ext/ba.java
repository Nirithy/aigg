package android.ext;

import android.os.Bundle;

class ba implements Runnable {
    final ar a;
    private boolean b;
    private final Bundle c;

    ba(ar ar0, Bundle bundle0) {
        this.a = ar0;
        this.c = bundle0;
        super();
        this.b = false;
    }

    @Override
    public void run() {
        la.a((this + ": 200"));
        if(this.b) {
            la.a((this + ": already"));
            return;
        }
        this.b = true;
        this.a.b(this.c);
    }
}

