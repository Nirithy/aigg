package android.ext;

class gl implements Runnable {
    final ex a;
    private final byte[] b;
    private final byte c;

    gl(ex ex0, byte[] arr_b, byte b) {
        this.a = ex0;
        this.b = arr_b;
        this.c = b;
        super();
    }

    @Override
    public void run() {
        this.a.e.a(this.c, 0x30, this.b.length + 4);
        this.a.e.a(this.b.length);
        this.a.e.a(this.b, this.b.length);
        this.a.u();
    }
}

