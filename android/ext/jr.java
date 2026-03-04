package android.ext;

class jr implements Runnable {
    final jp a;
    private final int b;

    jr(jp jp0, int v) {
        this.a = jp0;
        this.b = v;
        super();
    }

    @Override
    public void run() {
        jp.g.g &= ~this.b;
    }
}

