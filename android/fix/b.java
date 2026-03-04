package android.fix;

import android.content.Intent;

class b implements Runnable {
    final a a;
    private final Intent b;
    private final int c;

    b(a a0, Intent intent0, int v) {
        this.a = a0;
        this.b = intent0;
        this.c = v;
        super();
    }

    @Override
    public void run() {
        this.a.startActivityForResult(this.b, this.c);
    }
}

