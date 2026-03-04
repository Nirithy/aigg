package android.ext;

class fw implements Runnable {
    final ex a;
    private final byte b;
    private final byte c;

    fw(ex ex0, byte b, byte b1) {
        this.a = ex0;
        this.b = b;
        this.c = b1;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.b, 53, 0);
        this.a.e.a(this.c);
        this.a.u();
    }
}

