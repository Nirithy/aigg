package android.ext;

class fc implements Runnable {
    final ex a;
    private final byte[] b;
    private final byte[] c;
    private final byte d;
    private final long e;
    private final long f;
    private final int g;
    private final String h;

    fc(ex ex0, byte[] arr_b, byte[] arr_b1, byte b, long v, long v1, int v2, String s) {
        this.a = ex0;
        this.b = arr_b;
        this.c = arr_b1;
        this.d = b;
        this.e = v;
        this.f = v1;
        this.g = v2;
        this.h = s;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.d, 61, 0);
        this.a.e.a(this.e);
        this.a.e.a(this.f);
        this.a.e.a(this.g);
        this.a.e.a(this.b.length);
        this.a.e.a(this.b, this.b.length);
        this.a.e.a(this.c.length);
        this.a.e.a(this.c, this.c.length);
        this.a.u();
        MainService.instance.a(Tools.a("%s: %s - %s > %s", new Object[]{qk.a(0x7F0701A8), d.b(this.e, 4), d.b(this.f, 4), this.h}));  // string:dump_memory "Dump memory"
    }
}

