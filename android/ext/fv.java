package android.ext;

class fv implements Runnable {
    final ex a;
    private final gm b;
    private final byte c;

    fv(ex ex0, gm gm0, byte b) {
        this.a = ex0;
        this.b = gm0;
        this.c = b;
        super();
    }

    @Override
    public void run() {
        InOut inOut0 = this.a.e;
        for(int v = 0; v < this.b.a.length; v += v1) {
            int v1 = this.b.a.length - v <= 100000000 ? this.b.a.length - v : 100000000;
            inOut0.a(this.c, 52, (InOut.b + 4) * v1);
            inOut0.a(v1);
            int[] arr_v = this.b.b;
            long[] arr_v1 = this.b.a;
            int v2 = v + v1;
            for(int v3 = v; v3 < v2; ++v3) {
                inOut0.a(arr_v[v3]);
                inOut0.a(arr_v1[v3]);
            }
            this.a.u();
        }
    }
}

