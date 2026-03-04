package android.ext;

class fe implements Runnable {
    final ex a;
    private final byte b;
    private final int c;
    private final boolean[] d;
    private final long e;
    private final long f;
    private final double g;
    private final double h;

    fe(ex ex0, byte b, int v, boolean[] arr_z, long v1, long v2, double f, double f1) {
        this.a = ex0;
        this.b = b;
        this.c = v;
        this.d = arr_z;
        this.e = v1;
        this.f = v2;
        this.g = f;
        this.h = f1;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 35, 0);
        this.a.e.a(this.c | 17);
        this.a.a(this.d);
        this.a.e.b(this.e);
        this.a.e.b(this.f);
        this.a.e.b(Double.doubleToRawLongBits(this.g));
        this.a.e.b(Double.doubleToRawLongBits(this.h));
        this.a.u();
    }
}

