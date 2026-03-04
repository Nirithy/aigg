package android.ext;

class fm implements Runnable {
    final ex a;
    private final byte b;
    private final short c;
    private final int d;
    private final long e;
    private final long f;
    private final long g;

    fm(ex ex0, byte b, short v, int v1, long v2, long v3, long v4) {
        this.a = ex0;
        this.b = b;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = v4;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 0x40, 0);
        this.a.e.a(((int)this.c));
        this.a.e.a(this.d);
        this.a.e.a(this.e);
        this.a.e.a(this.f);
        this.a.e.a(this.g);
        this.a.u();
        ex.b = false;
    }
}

