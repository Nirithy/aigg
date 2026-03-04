package android.ext;

class ga implements Runnable {
    final ex a;
    private final byte b;
    private final byte c;

    ga(ex ex0, byte b, byte b1) {
        this.a = ex0;
        this.b = b;
        this.c = b1;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, this.c, 0);
        this.a.u();
    }
}

