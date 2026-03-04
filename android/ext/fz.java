package android.ext;

import android.os.Process;

class fz implements Runnable {
    final ex a;
    private final byte b;

    fz(ex ex0, byte b) {
        this.a = ex0;
        this.b = b;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 0x2F, 0);
        int v = Process.myPid();
        this.a.e.a(v);
        this.a.e.a(this.a.i);
        this.a.u();
    }
}

