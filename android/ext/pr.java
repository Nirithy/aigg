package android.ext;

class pr implements Runnable {
    final OffsetCalculator a;
    private final long b;
    private final long c;

    pr(OffsetCalculator offsetCalculator0, long v, long v1) {
        this.a = offsetCalculator0;
        this.b = v;
        this.c = v1;
        super();
    }

    @Override
    public void run() {
        try {
            this.a.a(this.b, this.c, false);
        }
        catch(Throwable throwable0) {
            la.b(("Failed update value: " + this.b + ' ' + this.c), throwable0);
        }
    }
}

