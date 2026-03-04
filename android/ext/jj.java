package android.ext;

class jj implements Runnable {
    final HotPoint a;
    private final byte b;
    private final long c;
    private final long d;
    private final int e;
    private final int f;
    private final String g;

    jj(HotPoint hotPoint0, byte b, long v, long v1, int v2, int v3, String s) {
        this.a = hotPoint0;
        this.b = b;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = s;
        super();
    }

    @Override
    public void run() {
        this.a.b(this.b, this.c, this.d, this.e, this.f, this.g);
    }
}

