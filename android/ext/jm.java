package android.ext;

class jm implements Runnable {
    final HotPoint a;
    private final String b;

    jm(HotPoint hotPoint0, String s) {
        this.a = hotPoint0;
        this.b = s;
        super();
    }

    @Override
    public void run() {
        this.a.m.setText(this.b);
        this.a.c();
    }
}

