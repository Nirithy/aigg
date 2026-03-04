package android.ext;

class gi implements Runnable {
    final ex a;
    private final int[] b;
    private final byte c;
    private final long[] d;

    gi(ex ex0, int[] arr_v, byte b, long[] arr_v1) {
        this.a = ex0;
        this.b = arr_v;
        this.c = b;
        this.d = arr_v1;
        super();
    }

    @Override
    public void run() {
        InOut inOut0 = this.a.e;
        for(int v = 0; v < this.b.length; v += v1) {
            int v1 = this.b.length - v <= 100000000 ? this.b.length - v : 100000000;
            inOut0.a(this.c, 36, (InOut.b + 4) * v1);
            inOut0.a(v1);
            int v2 = v + v1;
            for(int v3 = v; v3 < v2; ++v3) {
                int v4 = this.b[v3];
                if(v4 != 0) {
                    inOut0.a(v4);
                    inOut0.a(this.d[v3]);
                }
            }
            inOut0.a(0);
            this.a.u();
        }
    }
}

