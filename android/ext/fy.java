package android.ext;

class fy implements Runnable {
    final ex a;
    private final byte b;
    private final byte[] c;
    private final String d;

    fy(ex ex0, byte b, byte[] arr_b, String s) {
        this.a = ex0;
        this.b = b;
        this.c = arr_b;
        this.d = s;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 54, 0);
        this.a.e.a(Config.h);
        this.a.e.a(Config.A);
        this.a.e.b(Config.j);
        this.a.e.a(Config.m);
        this.a.e.a(Config.i);
        this.a.e.a(this.c.length);
        this.a.e.a(this.c, this.c.length);
        long v = this.a.e.d();
        if(v != this.a.m) {
            this.a.m = v;
            this.a.u();
            la.a(("Sended config: " + Config.h + ' ' + "0" + ' ' + "0" + ' ' + Config.m + ' ' + Config.i + ' ' + this.d + "; " + this.c.length));
        }
    }
}

