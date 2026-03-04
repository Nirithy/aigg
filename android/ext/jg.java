package android.ext;

class jg implements Runnable {
    final HotPoint a;

    jg(HotPoint hotPoint0) {
        this.a = hotPoint0;
        super();
    }

    @Override
    public void run() {
        this.a.k();
        Tools.a(this.a.g, 0.0f);
    }
}

