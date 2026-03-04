package android.ext;

class ft implements Runnable {
    final ex a;
    private final qx[] b;
    private final byte c;

    ft(ex ex0, qx[] arr_qx, byte b) {
        this.a = ex0;
        this.b = arr_qx;
        this.c = b;
        super();
    }

    @Override
    public void run() {
        InOut inOut0 = this.a.e;
        for(int v = 0; v < this.b.length; v += v1) {
            int v1 = this.b.length - v <= 100000000 ? this.b.length - v : 100000000;
            inOut0.a(this.c, 41, (InOut.b + 4) * v1);
            int v2 = v + v1;
            for(int v3 = v; v3 < v2; ++v3) {
                qx qx0 = this.b[v3];
                if(qx0.d != 0) {
                    inOut0.a(qx0.d);
                    inOut0.a(qx0.b);
                }
            }
            inOut0.a(0);
            this.a.u();
        }
    }
}

