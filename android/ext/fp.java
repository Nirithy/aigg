package android.ext;

class fp implements Runnable {
    final ex a;
    private final Object[] b;
    private final byte c;

    fp(ex ex0, Object[] arr_object, byte b) {
        this.a = ex0;
        this.b = arr_object;
        this.c = b;
        super();
    }

    @Override
    public void run() {
        d d0;
        int v5;
        InOut inOut0 = this.a.e;
        for(int v = 0; v < this.b.length; v += v2) {
            int v1 = this.b.length - v;
            int v2 = v1 <= 100000000 ? v1 : 100000000;
            inOut0.a(this.c, 43, (InOut.b + 16) * v2);
            inOut0.a(v2);
            int v3 = v + v2;
            for(int v4 = v; v4 < v3; ++v4) {
                Object object0 = this.b[v4];
                if(object0 instanceof gn) {
                    v5 = ((gn)object0).b;
                    d0 = ((gn)object0).a;
                }
                else {
                    d0 = (d)object0;
                    v5 = 0;
                }
                int v6 = d0.d;
                if(v6 != 0) {
                    inOut0.a(v6);
                    inOut0.a(d0.b);
                    inOut0.b(d0.c);
                    inOut0.a(v5);
                }
            }
            inOut0.a(0);
            this.a.u();
        }
    }
}

