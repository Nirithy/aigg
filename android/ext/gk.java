package android.ext;

import android.c.b;

class gk implements Runnable {
    final ex a;
    private final String b;
    private final String c;
    private final byte d;
    private final int e;

    gk(ex ex0, String s, String s1, byte b, int v) {
        this.a = ex0;
        this.b = s;
        this.c = s1;
        this.d = b;
        this.e = v;
        super();
    }

    @Override
    public void run() {
        int v = 0xFF;
        InOut inOut0 = this.a.e;
        byte[] arr_b = this.b.getBytes();
        int v1 = arr_b.length <= 0xFF ? arr_b.length : 0xFF;
        byte[] arr_b1 = this.c == null ? b.c : this.c.getBytes();
        if(arr_b1.length <= 0xFF) {
            v = arr_b1.length;
        }
        inOut0.a(this.d, 37, 0);
        inOut0.a(this.e);
        inOut0.a(((byte)v1));
        inOut0.a(arr_b, v1);
        inOut0.a(((byte)v));
        inOut0.a(arr_b1, v);
        this.a.u();
    }
}

