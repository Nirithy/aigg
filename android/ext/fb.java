package android.ext;

class fb implements Runnable {
    final ex a;
    private final byte b;
    private final int c;
    private final long d;

    fb(ex ex0, byte b, int v, long v1) {
        this.a = ex0;
        this.b = b;
        this.c = v;
        this.d = v1;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 0x20, 0);
        this.a.e.a(this.c);
        this.a.e.a(this.d);
        this.a.u();
    }
}

