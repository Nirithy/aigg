package android.ext;

class ff implements Runnable {
    final ex a;
    private final byte b;
    private final boolean[] c;
    private final int d;
    private final int e;
    private final long f;

    ff(ex ex0, byte b, boolean[] arr_z, int v, int v1, long v2) {
        this.a = ex0;
        this.b = b;
        this.c = arr_z;
        this.d = v;
        this.e = v1;
        this.f = v2;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 35, 0);
        this.a.e.a(16);
        this.a.a(this.c);
        this.a.e.a(this.d);
        this.a.e.a(this.e);
        this.a.e.b(this.f);
        this.a.u();
    }
}

