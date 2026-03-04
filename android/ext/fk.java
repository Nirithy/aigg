package android.ext;

class fk implements Runnable {
    final ex a;
    private final byte b;
    private final long c;
    private final long d;
    private final int e;
    private final long f;
    private final long g;
    private final long h;

    fk(ex ex0, byte b, long v, long v1, int v2, long v3, long v4, long v5) {
        this.a = ex0;
        this.b = b;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = v4;
        this.h = v5;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 0x3F, 0);
        this.a.e.a(this.c);
        this.a.e.a(this.d);
        this.a.e.a(this.e);
        this.a.e.a(this.f);
        this.a.e.a(this.g);
        this.a.e.a(this.h);
        this.a.u();
        ex.b = false;
    }
}

