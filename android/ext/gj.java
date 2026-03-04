package android.ext;

class gj implements Runnable {
    final ex a;
    private final byte b;
    private final long c;
    private final int d;

    gj(ex ex0, byte b, long v, int v1) {
        this.a = ex0;
        this.b = b;
        this.c = v;
        this.d = v1;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 50, 0);
        this.a.e.a(this.c);
        this.a.e.a(this.d);
        this.a.e.a(0);
        this.a.u();
    }
}

