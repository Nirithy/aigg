package android.ext;

class fn implements Runnable {
    final ex a;
    private final byte b;
    private final int c;
    private final long d;
    private final long e;
    private final long f;
    private final byte[] g;

    fn(ex ex0, byte b, int v, long v1, long v2, long v3, byte[] arr_b) {
        this.a = ex0;
        this.b = b;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = arr_b;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 34, 0);
        this.a.e.a(this.c);
        this.a.e.a(this.d);
        this.a.e.a(this.e);
        this.a.e.a(this.f);
        this.a.e.a(this.g.length);
        this.a.e.a(this.g, this.g.length);
        this.a.u();
        ex.b = false;
    }
}

