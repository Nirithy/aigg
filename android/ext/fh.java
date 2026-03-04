package android.ext;

class fh implements Runnable {
    final ex a;
    private final byte b;
    private final int c;
    private final boolean[] d;

    fh(ex ex0, byte b, int v, boolean[] arr_z) {
        this.a = ex0;
        this.b = b;
        this.c = v;
        this.d = arr_z;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 35, 0);
        this.a.e.a(this.c | 8);
        this.a.a(this.d);
        this.a.u();
    }
}

