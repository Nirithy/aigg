package android.ext;

class fj implements Runnable {
    final ex a;
    private final int[] b;
    private final byte c;
    private final int d;
    private final int e;
    private final long f;
    private final long g;
    private final long h;
    private final long[] i;
    private final long[] j;

    fj(ex ex0, int[] arr_v, byte b, int v, int v1, long v2, long v3, long v4, long[] arr_v1, long[] arr_v2) {
        this.a = ex0;
        this.b = arr_v;
        this.c = b;
        this.d = v;
        this.e = v1;
        this.f = v2;
        this.g = v3;
        this.h = v4;
        this.i = arr_v1;
        this.j = arr_v2;
        super();
    }

    @Override
    public void run() {
        InOut inOut0 = this.a.e;
        bp bp0 = new bp();
        bp0.a(qk.a(0x7F070118));  // string:union "Group search"
        bp0.a(" = ");
        inOut0.a(this.c, 55, 0);
        inOut0.a(this.d);
        inOut0.a(this.e);
        inOut0.a(this.f);
        inOut0.a(this.g);
        inOut0.a(this.h);
        inOut0.a(this.b.length);
        for(int v = 0; v < this.b.length; ++v) {
            this.i[v] = d.c(this.i[v], this.b[v]);
            this.j[v] = d.c(this.j[v], this.b[v]);
            inOut0.a(this.b[v]);
            inOut0.b(this.i[v]);
            inOut0.b(this.j[v]);
            String s = d.a(0L, this.i[v], this.b[v]);
            if((this.b[v] & 0x30000000) != 0) {
                s = String.valueOf(s) + '~' + d.a(0L, this.j[v], this.b[v]);
            }
            if((this.b[v] & 0x10000000) != 0) {
                s = "≠ " + s;
            }
            if(v != 0) {
                bp0.a("; ");
            }
            bp0.a(Tools.a((String.valueOf(s) + d.g(this.b[v])), d.k(this.b[v])));
        }
        this.a.u();
        bp0.a(" :");
        if((this.d & 0x400000) != 0) {
            bp0.a(":");
        }
        bp0.a(Tools.a("%,d", new Object[]{this.e}));
        MainService.instance.a(bp0.a());
        ex.b = false;
    }
}

