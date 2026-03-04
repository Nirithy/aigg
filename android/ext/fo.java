package android.ext;

class fo implements Runnable {
    final ex a;
    private final byte b;
    private final long c;
    private final long d;
    private final int e;
    private final int f;
    private final long g;
    private final long h;
    private final long i;

    fo(ex ex0, byte b, long v, long v1, int v2, int v3, long v4, long v5, long v6) {
        this.a = ex0;
        this.b = b;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = v4;
        this.h = v5;
        this.i = v6;
        super();
    }

    @Override
    public void run() {
        boolean z = false;
        this.a.e.a(this.b, 38, 0);
        this.a.e.b(this.c);
        this.a.e.b(this.d);
        this.a.e.a(this.e);
        this.a.e.a(this.f);
        this.a.e.a(this.g);
        this.a.e.a(this.h);
        this.a.e.a(this.i);
        this.a.u();
        if((this.f & 0x80000000) != 0) {
            z = true;
        }
        ex.b = z;
    }
}

