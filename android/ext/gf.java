package android.ext;

class gf implements Runnable {
    final ex a;
    private final byte b;

    gf(ex ex0, byte b) {
        this.a = ex0;
        this.b = b;
        super();
    }

    @Override
    public void run() {
        this.a.a(this.b, 1);
        this.a.b(this.b, 45);
        this.a.e.b(false);
        MainService.instance.G();
    }
}

